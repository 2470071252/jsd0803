package cn.tedu.coolshark.pojo.vo;

import lombok.Data;

@Data
public class ProductUpdateVO {
    private Integer id; // id
    private String title; // 商品标题
    private String url; // 图片路径
    private Double price; // 价格
    private Double oldPrice; // 原价
    private Integer saleCount; // 销量
    private Integer num; // 库存
    private Integer categoryId; //分类id
}
