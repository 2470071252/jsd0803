package cn.tedu.weibo02.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Weibo {
    private Integer id;
    private String content;
    private String urls;
    private Date created;
    private Integer userId;
}
