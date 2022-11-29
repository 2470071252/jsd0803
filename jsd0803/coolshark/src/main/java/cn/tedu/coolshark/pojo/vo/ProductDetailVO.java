package cn.tedu.coolshark.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import lombok.Data;

@Data
public class ProductDetailVO {
    private Integer id; // id
    private String title; // 商品标题
    private String url; // 图片路径
    private Double price; // 价格
    private Double oldPrice; // 原价
    private Integer saleCount; // 销量
    private Integer viewCount; // 浏览量
    @JsonFormat(pattern = "yyyy/mm/dd HH:mm:ss",timezone = "GMT+8")
    private Date created; // 发布时间
}
