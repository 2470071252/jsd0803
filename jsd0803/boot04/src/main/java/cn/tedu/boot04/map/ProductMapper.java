package cn.tedu.boot04.map;

import cn.tedu.boot04.entity.Product;
import org.apache.ibatis.annotations.*;
import java.util.List;

// 映射接口：是供Mybatis框架生成JDBC代码的依据，在接口中定义方法和书写写SQL语句
@Mapper  // 设置当前接口为映射接口，
public interface ProductMapper {

    // #{xxx}此指令会从注解下面的方法参数列表中找到同名变量
    // 如果没有，则会调用参数列表中变量的同名get方法
    @Insert("insert into product values(null,#{title},#{price},#{num})")
    void insert(Product product);

    /*
    * 声明返回值类型为List集合，Mybatis框架生成JDB代码时会自动将查询到的数据
    * 封装到Product对象里，并且把对象添加到一个List集合中，把集合return出来
    * */
    @Select("select id,title,price,num from product")
    List<Product> select();

    // 删除注解，定义删除相关的Sql语句
    @Delete("delete from product where id=#{id}")
    void deleteById(int id);

    // 修改注解，定义修改相关的SQL语句
    @Update("update product set title=#{title},price=#{price},num=#{num} where id=#{id}")
    void update(Product product);

}
