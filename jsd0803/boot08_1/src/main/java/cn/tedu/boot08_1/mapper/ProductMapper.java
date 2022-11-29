package cn.tedu.boot08_1.mapper;

import cn.tedu.boot08_1.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("select title from product where title=#{title}")
    Product selectByTitle(String title);

    @Insert("insert into product values(null,#{title},#{price},#{num})")
    void insert(Product product);

    @Select("select id,title,price,num from product")
    List<Product> select();

}
