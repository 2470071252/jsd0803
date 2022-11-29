package cn.tedu.boot08_1.controller;

import cn.tedu.boot08_1.entity.Product;
import cn.tedu.boot08_1.mapper.ProductMapper;
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
    public int add(@RequestBody Product p){
        Product product = mapper.selectByTitle(p.getTitle());
        if (product!=null) {
            return 2;  // 商品名已经存在
        }
        mapper.insert(p);
        return 1; //添加成功
    }

    @RequestMapping("/list")
    public List<Product> list(){
        List<Product> list = mapper.select();
        return list;
    }
}
