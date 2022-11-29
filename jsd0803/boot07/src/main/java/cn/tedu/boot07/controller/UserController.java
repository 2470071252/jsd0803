package cn.tedu.boot07.controller;

import cn.tedu.boot07.mapper.UserMapper;
import cn.tedu.boot07.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserMapper mapper;
    @RequestMapping("/reg")
    public int reg(@RequestBody User user){
        System.out.println("user="+user);
        // 查询用户名是否存在
        User u = mapper.selectByUsername(user.getUsername());
        // statusCode:1为注册成功，2为用户存在
        if (u!=null){
            return 2;
        }
        mapper.insert(user);
        return 1;

    }

    @RequestMapping("/login")
    public int login(@RequestBody User user){
        System.out.println("user="+user);
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null) {
            if (u.getPassword().equals(user.getPassword())){
                return 1;
            }
            return 3;
        }
        return 2;
    }

}
