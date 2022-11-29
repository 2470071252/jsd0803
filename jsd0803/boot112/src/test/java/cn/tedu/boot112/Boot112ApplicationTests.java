package cn.tedu.boot112;

import cn.tedu.boot112.entity.Product;
import cn.tedu.boot112.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Boot112ApplicationTests {

//    @Test
//    void contextLoads() {
//    }

    @Autowired(required = false)
    ProductMapper mapper;

    @Test
    void test1(){
        Product p1 = new Product();
        p1.setNum(122);
        p1.setTitle("product1");
        p1.setPrice(14.0);
        mapper.insert(p1);

    }

    @Test
    void test2(){
        List<Product> list = new ArrayList<>();
        Product p1 = new Product();
        Product p2 = new Product();

        p1.setNum(12);
        p1.setTitle("product2");
        p1.setPrice(17.0);

        p2.setNum(129);
        p2.setTitle("product3");
        p2.setPrice(44.0);

        list.add(p1);
        list.add(p2);

        mapper.insertMulti(list);
    }

    @Test
    void test3(){
        mapper.deleteById(3);
    }

    @Test
    void test4(){
        mapper.deleteByIdMulti(4,5);
    }

    @Test
    void test5(){
        Product p1 = new Product();
        p1.setTitle("ccc");
        p1.setId(7);
        mapper.dynamicUpdate(p1);
    }

    @Test
    void test6(){
        System.out.println(mapper.selectById(7));
    }

    @Test
    void test7(){
        System.out.println(mapper.select());
    }

    @Test
    void test8(){
        System.out.println(mapper.selectCount());
    }

}
