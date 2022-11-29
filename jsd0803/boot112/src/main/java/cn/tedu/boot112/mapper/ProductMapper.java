package cn.tedu.boot112.mapper;

import cn.tedu.boot112.entity.Product;

import java.util.List;

public interface ProductMapper {

    void insert(Product product);

    int insertMulti(List<Product> list);

    int deleteById(int id);

    int deleteByIdMulti(Integer... ids);

    int dynamicUpdate(Product product);

    Product selectById(int id);

    List<Product> select();

    int selectCount();

}
