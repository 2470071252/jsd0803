package cn.tedu.boot10.mapper;

// 因为使用了MapperScan注解所以这里不再写@Mapper注解
import cn.tedu.boot10.entity.Product;

import java.util.List;

public interface ProductMapper {
    // 此处不再使用@Insert注解配置SQL语句，而是写在xml配置文件中
    void insert(Product product);

    List<Product> select();

    void deleteById(int id);

    void update(Product product);
    // 查询单个商品信息
    Product selectById(int id);
}
