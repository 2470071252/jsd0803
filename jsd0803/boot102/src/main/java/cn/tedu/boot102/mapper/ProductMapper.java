package cn.tedu.boot102.mapper;

import cn.tedu.boot102.entity.Product;

import java.util.List;

public interface ProductMapper {

    void insert(Product product);

    void deleteById(int id);

    List<Product> select(Product product);

    void update(Product product);

    Product selectById(int id);


}
