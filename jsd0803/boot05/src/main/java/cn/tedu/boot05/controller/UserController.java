package cn.tedu.boot05.controller;

import cn.tedu.boot05.entity.User;
import cn.tedu.boot05.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserMapper mapper;

    @RequestMapping("/reg")
    public String reg(User user){
        System.out.println("user = " + user);
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null) {
            return "用户已存在";
        }
        mapper.insert(user);
        return "注册成功!<a href='/'>跳转首页</a>";
    }

    @RequestMapping("/login")
    public String login(User user){
        System.out.println("user = " + user);
        User u = mapper.selectByUsername(user.getUsername());
        if (u==null) {
            return "用户名不存在 <a href='/login.html'>重新登陆</a>";
        }else if (u.getPassword().equals(user.getPassword())){
            return "登陆成功 <a href='/'>回到首页</a>";
        }
        return "密码错误 <a href='/login.html'>重新登陆</a>";

    }


}
