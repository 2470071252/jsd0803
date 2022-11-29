package cn.tedu.boot102.controller;

import cn.tedu.boot102.entity.Product;
import cn.tedu.boot102.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired(required = false)
    ProductMapper mapper;

    // 添加商品Controller
    @RequestMapping("/add")
    void insert(@RequestBody Product product){
        mapper.insert(product);
    }

    // list.html初始化商品数据
    @RequestMapping("/list")
    List<Product> select(Product product){
        return mapper.select(product);
    }

    // 删除商品
    @RequestMapping( "/delete")
    void deleteById(int id){
        mapper.deleteById(id);
    }

    // 修改商品
    @RequestMapping("/update")
    void update(@RequestBody Product product){
        mapper.update(product);

    }

    @RequestMapping("selectById")
    Product selectById(int id){
        return mapper.selectById(id);
    }


}
