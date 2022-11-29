package cn.tedu.boot101;

import cn.tedu.boot101.entity.Product;
import cn.tedu.boot101.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Boot101ApplicationTests {

    @Autowired(required = false)
    ProductMapper mapper;

    @Test
    void contextLoads() {
        Product p = new Product();
        p.setTitle("柚子");
        p.setPrice(12);
        p.setNum(512);
        mapper.insert(p);
    }

}
