package cn.tedu.weibo02.mapper;

import cn.tedu.weibo02.pojo.dto.UserRegDTO;
import cn.tedu.weibo02.pojo.vo.UserVO;

public interface UserMapper {
    // reg
    void insert(UserRegDTO user);

    UserVO selectByUsername(String username);

    //login

}
