package cn.tedu.weibo02.controller;

import cn.tedu.weibo02.mapper.UserMapper;
import cn.tedu.weibo02.pojo.dto.UserLoginDTO;
import cn.tedu.weibo02.pojo.dto.UserRegDTO;
import cn.tedu.weibo02.pojo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
public class UserController {
    @Autowired(required=false)
    UserMapper mapper;

    @RequestMapping("/reg")
    public int reg(@RequestBody UserRegDTO user){
        UserVO u = mapper.selectByUsername(user.getUsername());
        if (u!=null) {
            return 2;
        }
        mapper.insert(user);
        return 1;
    }

    @RequestMapping("/login")
    public int login(@RequestBody UserLoginDTO user,HttpSession session){
        UserVO u = mapper.selectByUsername(user.getUsername());
        if (u!=null) {
            if (u.getPassword().equals(user.getPassword())) {
                session.setAttribute("user",u);
                return 1;
            }
            return 2;
        }
        return 3;
    }

    @RequestMapping("/currentUser")
    UserVO currentUser(HttpSession session){
        return (UserVO) session.getAttribute("user");
    }

    @RequestMapping("/logout")
    void logout(HttpSession session){
        session.removeAttribute("user");
    }
}
