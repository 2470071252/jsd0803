package cn.tedu.boot05.mapper;

import cn.tedu.boot05.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    /*
    * 如果查询的是一个对象的信息，查询到了内容则查询到的数据封装到对象里面返回
    * 如果没有查询到则会返回null
    * 如果返回值是一个对象不是集合，但是查询到的数据出现大于一条的情况会报错*/
    @Select("select password from user where username=#{username}")
    User selectByUsername(String username);

    // Register相关
    @Insert("insert into user values(null,#{username},#{password},#{nickname})")
    void insert(User user);



}
