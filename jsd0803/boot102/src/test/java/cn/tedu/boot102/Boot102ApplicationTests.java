package cn.tedu.boot102;

import cn.tedu.boot102.entity.Product;
import cn.tedu.boot102.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Boot102ApplicationTests {

    @Autowired(required = false)
    ProductMapper mapper;

    @Test
    void contextLoads() {
        Product p = new Product();
        p.setNum(12);
        p.setPrice(1);
        p.setTitle("TestProduct");
        mapper.insert(p);
    }

}
