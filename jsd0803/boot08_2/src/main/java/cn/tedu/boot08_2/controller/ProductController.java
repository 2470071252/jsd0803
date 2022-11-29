package cn.tedu.boot08_2.controller;

import cn.tedu.boot08_2.entity.Product;
import cn.tedu.boot08_2.mapper.ProductMapper;
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
    public int add(@RequestBody Product product){
        Product p1 = mapper.selectByTitle(product);
        if (p1!=null) {
            return 2;
        }
        mapper.insert(product);
        return 1;
    }

    @RequestMapping("/list")
    public List<Product> list(){
        return  mapper.selectList();
    }

    @RequestMapping("/delete")
    public void delete(@RequestBody int id){
        mapper.deleteById(id);
    }

    @RequestMapping("/listById")
    public List<Product> listById(Product product){
        return mapper.selectById(product);
    }

    @RequestMapping("/update")
    public void update(@RequestBody Product product){
        mapper.update(product);
    }
}
