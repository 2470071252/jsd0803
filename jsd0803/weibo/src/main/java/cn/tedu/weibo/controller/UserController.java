package cn.tedu.weibo.controller;

import cn.tedu.weibo.mapper.UserMapper;
import cn.tedu.weibo.pojo.dto.UserLoginDto;
import cn.tedu.weibo.pojo.dto.UserRegDto;
import cn.tedu.weibo.pojo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;

    @RequestMapping("/reg")
    public int reg(@RequestBody UserRegDto user) {
        System.out.println("user = " + user);
        UserVO u = mapper.selectByUsername(user.getUsername());
        if (u!=null) {
            return 2; // 说明用户名已经存在
        }
        mapper.insert(user);  //执行数据库插入语句
        return 1;   // 创建成功
    }

    @RequestMapping("/login")
    public int login(@RequestBody UserLoginDto user, HttpSession session ){
        System.out.println("user = " + user);
        UserVO u = mapper.selectByUsername(user.getUsername());
        if (u!=null) {
            if (u.getPassword().equals(user.getPassword())){
                session.setAttribute("user",u);
                return 1;
            }
            return 3;
        }
        return 2;
    }

    @RequestMapping("/currentUser")
    public UserVO currentUser(HttpSession session){
        return (UserVO) session.getAttribute("user");
    }

    @RequestMapping("/logout")
    public void logout(HttpSession session){
        // 删除登陆成功时保存的用户对象
        session.removeAttribute("user");
    }
}
