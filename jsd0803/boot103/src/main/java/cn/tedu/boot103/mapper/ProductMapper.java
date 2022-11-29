package cn.tedu.boot103.mapper;

import cn.tedu.boot103.entity.Product;

import java.util.List;

public interface ProductMapper {
    // 添加商品
    void insert(Product product);

    // 商品列表
    List<Product> select();

    // 判断商品是否存在
    Product selectByTitle(String title);

    // 删除商品
    void deleteById(int id);

    Product selectById(int id);

    void update(Product product);

}
