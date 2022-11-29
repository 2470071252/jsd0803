package cn.tedu.boot08.mapper;

import cn.tedu.boot08.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert("insert into product values(null,#{title},#{price},#{num})")
    void insert(Product product);

    @Select("select title from product where title=#{title}")
    Product selectByTitle(Product product);

    @Select("select id,title,price,num from product")
    List<Product> select();

    @Update("update product set title=#{title},price=#{price},num=#{num} where id=#{id}")
    void update(Product product);

    @Delete("delete from product where id=#{id}")
    void deleteById(int id);

    @Select("select id,title,price,num from product where id=#{id}")
    Product selectById(int id);
}
