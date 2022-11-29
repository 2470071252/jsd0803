package com.tedu.boot02.Controller;

import com.tedu.boot02.entity.User;
import com.tedu.boot02.utils.DBUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class UserController {

    @RequestMapping("/reg")
    @ResponseBody
    public String reg(User user) {
        // soutp 将参数列表中的参数在控制台输出，用于打桩
        System.out.println("user = " + user);
        // 获取数据库连接
        try (
           Connection connection = DBUtils.getConnection()
        )
        {
            String sql = "insert into " +
                    "user VALUES (null,?,?,?);";
            //创建执行sql语句对象
            PreparedStatement ps = connection.prepareStatement(sql);
            // 替换sql语句中的对象
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getNickname());
            // 执行插入SQL语句
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "注册成功";
    }

    @ResponseBody
    @RequestMapping("/login")
    public String login(User user){
        System.out.println("user = " + user);
        try (
           Connection connection = DBUtils.getConnection();
        ){
            String sql = "select password from user where username=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ResultSet rs = ps.executeQuery();
            // 判读是否查询到了数据
            if (rs.next()) {// 满足条件代表用户名存在
                // 判断查询到的密码(rs.getString(1))和
                // 用户输入的密码(user.getPasswrod)是否一致
                if (rs.getString(1).equals(user.getPassword())) {
                    return "登陆成功";
                }
                return "密码错误";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "用户名不存在";
    }
}
