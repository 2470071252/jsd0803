package cn.tedu.weibo01.mapper;

import cn.tedu.weibo01.pojo.dto.UserRegDTO;
import cn.tedu.weibo01.pojo.entity.User;
import cn.tedu.weibo01.pojo.vo.UserVO;

import java.util.List;


public interface UserMapper {

    UserVO selectByUsername(String username);

    List<User> select();

    void insert(UserRegDTO user);
}
