package cn.tedu.boot08_2.mapper;


import cn.tedu.boot08_2.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Select("select title from product where title=#{title}")
    Product selectByTitle(Product product);

    @Insert("insert into product set title=#{title}, price=#{price}, num=#{num}")
    void insert(Product product);

    @Select("select id,title,price,num from product")
    List<Product> selectList();

    @Delete("delete from product where id=#{id}")
    void deleteById(int id);

    @Select("select id,title,price,num from product where id=#{id}")
    List<Product> selectById(Product product);

    @Update("update product set id=#{id},title=#{title},price=#{price},num=#{num}")
    void update(Product product);


}
