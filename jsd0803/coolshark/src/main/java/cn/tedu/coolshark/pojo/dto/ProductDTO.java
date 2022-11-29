package cn.tedu.coolshark.pojo.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String title;
    private String url;
    private Double price;
    private Double oldPrice;
    private Integer saleCount;
    private Integer num;
    private Integer categoryId;
}
