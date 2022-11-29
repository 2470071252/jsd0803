package cn.tedu.coolshark.pojo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ProductAdminVO {
    private Integer id; // id
    private String title; // 商品标题
    private String url; // 图片路径
    private Double price; // 价格
    private Integer saleCount; // 销量
}
