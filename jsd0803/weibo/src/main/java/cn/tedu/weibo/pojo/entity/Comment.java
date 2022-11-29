package cn.tedu.weibo.pojo.entity;

import lombok.Data;

import java.util.Date;

// 实体类和表一一对应
@Data
public class Comment {
    private Integer id;
    private String content;
    private Integer weiboId; // 原微博id
    private Integer userId;  // 作者id
    private Date created;   // 发布时间
    /*
    * use weibo;
    * create table comment(
    *   id int primary key auto_increment,
    *   content varchar(100),
    *   weibo_id int,
    *   user_id int,
    *   created timestamp
    * );
    * */
}
