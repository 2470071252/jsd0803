package cn.tedu.boot04.controller;

import cn.tedu.boot04.entity.Product;
import cn.tedu.boot04.map.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
@RestController  // 相当于在每一个方法的上面都添加了一个@ResponseBody注解(@Controller+@ResponseBody)
public class ProductController {
    // AutoWired自动装配注解，此注解是Spring框架中提供的注解
    // 此注解添加后是Spring框架和Mybatis框架结合到一起，创建了一个
    // 接口的实现类，并且实例化了该实现类，并赋值给了mapper变量
    // 实现类中实现了接口里面的抽象方法(insert)
    // @Autowired(required =false) 告诉idea该Mapper不是必须的
    @Autowired
    ProductMapper mapper;

    @RequestMapping("/insert")
    public String insert(Product product){
        System.out.println("product = " + product);
        mapper.insert(product);
        return "添加完成！<a href='/'>返回首页</a>";
    }

    @RequestMapping("/select")
    public String select(){
        List<Product> list = mapper.select();
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
    public String delete(int id){
        System.out.println("id = " + id);
        mapper.deleteById(id);
        return "删除完成！<a href='/'>返回首页</a>";
    }

    @RequestMapping("/update")
    public String update(Product product){
        mapper.update(product);
        return "修改完成！<a href='/'>返回首页</a>";
    }

}
