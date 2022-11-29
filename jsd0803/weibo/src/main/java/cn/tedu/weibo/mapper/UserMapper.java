package cn.tedu.weibo.mapper;

import cn.tedu.weibo.pojo.dto.UserRegDto;
import cn.tedu.weibo.pojo.vo.UserVO;

public interface UserMapper {

    void insert(UserRegDto user);

    UserVO selectByUsername(String username);
}
