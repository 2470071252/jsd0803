package cn.tedu.boot08.controller;

import cn.tedu.boot08.entity.Product;
import cn.tedu.boot08.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductMapper mapper;

    @RequestMapping("/add")
    public int add( @RequestBody Product p){
        System.out.println("p="+p);
        Product product = mapper.selectByTitle(p);
        if (product!=null) {
            return 2;
        }
        mapper.insert(p);
        return 1;
    }

    @RequestMapping("/list")
    public List<Product> list(){
        List<Product> productList = mapper.select();
        // 把装着Product对象的List集合直接响应给客户端
        // 当返回值为List集合或自定义对象时，SpringMVC框架会自动
        // 将结合或对象转成JSON格式的字符串 再进行网络传输
        return productList;

    }

    @RequestMapping("/delete")
    void delete(int id){
        System.out.println("id="+id);
        mapper.deleteById(id);

    }

    @RequestMapping("selectById")
    Product selectById(int id){
        return mapper.selectById(id);
    }

    @RequestMapping("/update")
    void update(@RequestBody Product p){
        mapper.update(p);
    }
}
