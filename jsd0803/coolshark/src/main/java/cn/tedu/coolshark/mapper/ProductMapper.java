package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.pojo.dto.ProductUpdateDTO;
import cn.tedu.coolshark.pojo.vo.*;
import cn.tedu.coolshark.pojo.entity.Product;

import java.util.List;

public interface ProductMapper {

    void insert(Product p);

    List<ProductAdminVO> selectForAdmin();

    void deleteById(int id);

    String selectUrlById(int id);

    List<ProductIndexVO> selectForIndex();

    List<ProductTopVO> selectForTop();

    ProductDetailVO selectById(int id);

    List<ProductIndexVO> selectByCid(int id);

    List<ProductIndexVO> selectByWd(String wd);

    ProductUpdateVO selectForUpdateById(int id);

    void update(ProductUpdateDTO product);
}
