package cn.tedu.boot03_1.controller;

import cn.tedu.boot03_1.entity.Product;
import cn.tedu.boot03_1.utlis.DBUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class ProductController {
    @RequestMapping("/insert")
    @ResponseBody
    public String insert(String title, int price, int num) {
        try (
                Connection connection = DBUtil.getConnection();
        ) {
            String sql = "insert into product values(null,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, title);
            ps.setInt(2, price);
            ps.setInt(3, num);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "添加成功";

    }

    @RequestMapping("/select")
    @ResponseBody
    public String select() {
        ArrayList<Product> list = new ArrayList<>();
        try (
                Connection connection = DBUtil.getConnection();
        ) {
            String sql = "select id,title,price,num from product";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                int price = rs.getInt(3);
                int num = rs.getInt(4);
                Product p = new Product();
                p.setId(id);
                p.setTitle(title);
                p.setPrice(price);
                p.setNum(num);
                list.add(p);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // 把集合中的数据装进table表格中
        String html = "<table border='1'>";
        html += "<caption>商品列表</caption>";
        html += "<tr><th>id</th><th>标题</th><th>价格</th><th>库存</th><th>操作</th></tr>";
        // 遍历集合 添加tr和td
        for (Product p : list) {
            html += "<tr>";
            html += "<td>" + p.getId() + "</td>";
            html += "<td>" + p.getTitle() + "</td>";
            html += "<td>" + p.getPrice() + "</td>";
            html += "<td>" + p.getNum() + "</td>";
            // 添加删除超链接的一列，请求地址为/delete?id=xx
            html += "<td><a href='/delete?id=" + p.getId() + "'>删除</a></td>";
            html += "</tr>";
        }
        return html;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(int id) {
        try (
                Connection connection = DBUtil.getConnection();
        ) {
            String sql = "delete from product\n" +
                    "where id=?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String html = "<a href='/'>返回首页</a>";
        return "删除成功" + html;
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(int id, String title, int price, int num) {
        try (
                Connection connection = DBUtil.getConnection();
        ) {
            String sql = "update product\n" +
                    "set  title=?,price=?,num=? \n" +
                    "where id=?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,title);
            ps.setInt(2,price);
            ps.setInt(3,num);
            ps.setInt(4,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String html = "<a href='/'>点击跳主页</a>";
        return "修改成功！"+html;
    }

}
