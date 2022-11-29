package cn.tedu.boo02_1.Controller;

import cn.tedu.boo02_1.Utils.DBUtil;
import cn.tedu.boo02_1.entity.User;
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
    public String reg(User user){
        System.out.println("user = " + user);
        try (
                Connection connection = DBUtil.getConnection();
        ){
            String sql = "insert into user values(null,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getNickname());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "注册成功";

    }

    @ResponseBody
    @RequestMapping("/login")
    public String login(User user){
        try (
                Connection connection=DBUtil.getConnection();

        ){
            String sql = "select password from user\n" +
                    "where username=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
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
