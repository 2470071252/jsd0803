package cn.tedu.boot08_2.controller;

import cn.tedu.boot08_2.entity.User;
import cn.tedu.boot08_2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserMapper mapper;

    @RequestMapping("/login")
    int login(@RequestBody User user){
        User u = mapper.selectByUsername(user);
        if (u!=null){
            if (u.getPassword().equals(user.getPassword())) {
                return 1; // 登陆成功
            }
            return 2; // 用户名密码错误
        }
        return 3;  // 用户名不存在
    }

    @RequestMapping("/reg")
    int reg(@RequestBody User user){
        User u1 =mapper.selectByUsername(user);

        if (u1!=null) {
            return 2; // 用户名已存在
        }
        mapper.insert(user);
        return 1;  // 注册成功
    }


}
