package com.example.boot01_2.controller;

import com.example.boot01_2.entity.User;
import com.example.boot01_2.jdbc.DBUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class UserController {
    private static Connection connection;

    static {
        try {
            connection = DBUtils.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @RequestMapping("/reg")
    @ResponseBody
    public String reg(User usr) throws SQLException {
//        Connection connection = DBUtils.getConnection();
        String sql = "insert into user\n" +
                "    (username, password, nickname, age) \n" +
                "    VALUES (?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, usr.getUsername());
        ps.setString(2, usr.getPassword());
        ps.setString(3, usr.getNickname());
        ps.setInt(4, usr.getAge());
        int count = ps.executeUpdate();
        if (count > 0) {
            return "Successfully";
        }
        return "error";
    }

    @ResponseBody
    @RequestMapping("/login")
    public String login(User usr) throws SQLException {
        String sql = "select username" +
                "from user\n" +
                "where username=? and password = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, usr.getUsername());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return "登陆成功";
        }
        return "登陆失败";
    }

}
