package cn.tedu.coolshark.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Product {
    private Integer id; // id
    private String title; // 商品标题
    private String url; // 图片路径
    private Double price; // 价格
    private Double oldPrice; // 原价
    private Integer saleCount; // 销量
    private Integer num; // 库存
    private Integer viewCount; // 浏览量
    private Date created; // 发布时间
    private Integer categoryId; //分类id

}
