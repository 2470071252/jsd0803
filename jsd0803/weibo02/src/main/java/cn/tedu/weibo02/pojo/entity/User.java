package cn.tedu.weibo02.pojo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
}
