package cn.tedu.boot103.controller;

import cn.tedu.boot103.entity.Product;
import cn.tedu.boot103.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired(required = false)
    ProductMapper mapper;

    @RequestMapping("/add")
    int insert(@RequestBody Product product){

        System.out.println("product = " + product);

        Product p = mapper.selectByTitle(product.getTitle());
        if (p!=null) {
            return 2;
        }
        mapper.insert(product);
        return 1;
    }

    @RequestMapping("/list")
    List<Product> select(){
        return mapper.select();
    }

    @RequestMapping("/delete")
    void deleteById(int id){
        mapper.deleteById(id);
    }

    @RequestMapping("/update")
    void update(@RequestBody Product product){
        mapper.update(product);
    }

    @RequestMapping("/selectById")
    Product selectById(int id){
        return mapper.selectById(id);
    }

}
