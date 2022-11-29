package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.pojo.vo.UserVO;

public interface UserMapper {
    UserVO selectByUsername(String username);

}