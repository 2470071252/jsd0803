package cn.tedu.boot3.controller;

import cn.tedu.boot3.Utils.DBUtil;
import cn.tedu.boot3.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;
import java.util.ArrayList;

@Controller
public class ProductController {
    @RequestMapping("/insert")
    @ResponseBody
    public String insert(Product product) {
        System.out.println("product = " + product);

        try (
                Connection connection = DBUtil.getConnection();
        ) {
            String sql = "insert into product values(null,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, product.getTitle());
            ps.setInt(2, product.getPrice());
            ps.setInt(3, product.getNum());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String html = "<a href='/'>返回首页</a>";
        return "添加成功" + html;
    }

    @ResponseBody
    @RequestMapping("/select")
    public String select() {
        // 创建一个ArrayList集合对象，把查询到的多个商品对象保存
        ArrayList<Product> list = new ArrayList<>();
        try (// 获取数据库连接
             Connection connection = DBUtil.getConnection();
        ) {
            // 准备执行的SQL语句
            String sql = "SELECT id,title,price,num FROM product";
            // 创建执行SQL语句的对象
            PreparedStatement ps = connection.prepareStatement(sql);
            // 执行查询
            ResultSet rs = ps.executeQuery();
            // 遍历结果集对象
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                int price = rs.getInt(3);
                int num = rs.getInt(4);
                // 创建商品对象并把查询到的数据封装到对象中
                Product p = new Product();
                p.setId(id);
                p.setTitle(title);
                p.setPrice(price);
                p.setNum(num);
                // 把对象装进list集合
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
        html += "</table>";

        return html;  // 将页面和数据一起返回给客户端
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(int id) {
        System.out.println(id);
        try (
                Connection connection = DBUtil.getConnection();
        ) {
            String sql = "delete from product\n" +
                    "where id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String html = "<a href='/select'>返回商品列表</a>";
        return "删除成功" + "! " + html;
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(int id, String title, int price, int num) {
        System.out.println("id = " + id + ", title = " + title + ", price = " + price + ", num = " + num);
        try (
                Connection connection = DBUtil.getConnection();
        ) {
            String sql ="update product set title=?,price=?,num=?\n" +
                    "where id=?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, title);
            ps.setInt(2, price);
            ps.setInt(3, num);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String html = "<a href='/select'>返回商品列表</a>";
        return "修改成功" + html;
    }
}
