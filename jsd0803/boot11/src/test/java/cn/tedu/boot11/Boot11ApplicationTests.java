package cn.tedu.boot11;

import cn.tedu.boot11.entity.Product;
import cn.tedu.boot11.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Boot11ApplicationTests {

    @Autowired(required = false)
    ProductMapper mapper;

    @Test
    void contextLoads() {
        System.out.println(mapper.count());
    }

    @Test
    void t1() {
        // 测试批量删除
        ArrayList<Integer> list = new ArrayList<>();
        list.add(45);
        list.add(46);
        int i = mapper.deleteByIds1(list);
        System.out.println("批量删除" + i + "行");
    }

    @Test
    void t2() {
        Integer[] ids = {41, 42};
        int i = mapper.deleteByIds2(ids);
        System.out.println(i);
    }

    @Test
    void t3(){
        System.out.println(mapper.deleteByIds3(43,44));
    }

    @Test
    void t4(){
        Product p1 = new Product();
        p1.setTitle("aaa");
        p1.setPrice(345);
        p1.setNum(112);

        Product p2 = new Product();
        p2.setTitle("bbb");
        p2.setPrice(3);
        p2.setNum(1143);

        ArrayList<Product> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);

        int i = mapper.insertProducts(list);
        System.out.println("插入了"+i+"个对象");

    }

    @Test
    void t5(){
        // 动态修改
        Product p = new Product();
        p.setId(48);
        p.setTitle("ccc");
        mapper.dynamicUpdate(p);
    }

    @Test
    void t6(){
        System.out.println(mapper.selectById(37));
        System.out.println(mapper.select());
    }

}
