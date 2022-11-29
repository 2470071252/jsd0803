package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.pojo.dto.UserLoginDTO;
import cn.tedu.coolshark.mapper.UserMapper;
import cn.tedu.coolshark.pojo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;

    @RequestMapping("/login")
    public int login(@RequestBody UserLoginDTO user, HttpSession session, HttpServletResponse response){
        System.out.println("user = " + user);
        UserVO u = mapper.selectByUsername(user.getUsername());
        if (u!=null) {
            if (u.getPassword().equals(user.getPassword())) {
                // 判断是否需要记住用户名和密码
                if (user.getRem()) {
                    // 通过Cookie保存用户名和密码
                    Cookie c1 = new Cookie("username",user.getUsername());
                    Cookie c2 = new Cookie("password",user.getPassword());
                    // 设置保存时间 保存一个月
                    c2.setMaxAge(60*60*24*30);
                    c1.setMaxAge(60*60*24*30);
                    // 把Cookie发送给客户端
                    response.addCookie(c1);
                    response.addCookie(c2);
                }

                // 把当前登陆成功的对象保存到session会话里面
                session.setAttribute("user",u);
                return 1;
            }
            return 2;
        }
        return 3;
    }
    @RequestMapping("/currentUser")
    public UserVO currentUser(HttpSession session){
        // 把登陆成功时保存在会话对象里面的user响应个客户端
        return (UserVO) session.getAttribute("user");
    }
    @RequestMapping("/logout")
    public void logout(HttpSession session){
        // 删除回话对象中登陆成功时保存的user
        session.removeAttribute("user");
    }

}
