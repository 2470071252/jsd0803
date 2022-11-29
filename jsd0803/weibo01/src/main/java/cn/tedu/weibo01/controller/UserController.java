package cn.tedu.weibo01.controller;


import cn.tedu.weibo01.mapper.UserMapper;
import cn.tedu.weibo01.pojo.dto.UserLoginDTO;
import cn.tedu.weibo01.pojo.dto.UserRegDTO;
import cn.tedu.weibo01.pojo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;

    @RequestMapping("reg")
    int reg(@RequestBody UserRegDTO user) {
        UserVO u = mapper.selectByUsername(user.getUsername());
        if (u != null) {
            return 2;
        }
        mapper.insert(user);
        return 1;
    }

    @RequestMapping("/login")
    int login(@RequestBody UserLoginDTO user, HttpSession session) {
        System.out.println("user = " + user);
        UserVO u = mapper.selectByUsername(user.getUsername());
        if (u != null) {
            if (u.getPassword().equals(user.getPassword())) {
                session.setAttribute("user",u);  // session对象为含有id，password，nickname属性
                return 1;
            }
            return 2;
        }
        return 3;
    }
}
