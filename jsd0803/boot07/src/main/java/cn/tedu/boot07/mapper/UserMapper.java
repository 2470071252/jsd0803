package cn.tedu.boot07.mapper;

import cn.tedu.boot07.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user values(null,#{username},#{password},#{nickname})")
    void insert(User user);

    @Select("Select password from user where username=#{username}")
    User selectByUsername(String username);




}
