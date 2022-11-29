package cn.tedu.boot10;

import cn.tedu.boot10.entity.Product;
import cn.tedu.boot10.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class Boot10ApplicationTests {

    @Autowired(required = false)
    ProductMapper mapper;

    @Test
    void contextLoads() {
        Product p = new Product();
        p.setTitle("帅师傅冰红茶");
        p.setPrice(3);
        p.setNum(100);
        mapper.insert(p);
    }
    @Test // 单元测试方法要求无参无返回值
    void t1(){
        List<Product> list = mapper.select();
        System.out.println(list);
    }

    @Test
    void t2(){
        mapper.deleteById(22);
    }

    @Test
    void t3(){
        Product p = new Product();
        p.setId(20);
        p.setTitle("康帅傅冰红茶");
        p.setPrice(2);
        p.setNum(799);
        mapper.update(p);
    }

    @Test
    void t4(){
        Product p = mapper.selectById(20);
        System.out.println(p);
    }

}
