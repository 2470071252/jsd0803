package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.mapper.ProductMapper;
import cn.tedu.coolshark.pojo.dto.ProductDTO;
import cn.tedu.coolshark.pojo.dto.ProductUpdateDTO;
import cn.tedu.coolshark.pojo.entity.Product;
import cn.tedu.coolshark.pojo.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired(required = false)
    ProductMapper mapper;

    @RequestMapping("/insert")
    public void insert(@RequestBody ProductDTO product){
        // 把dot装进实体类
        Product p = new Product();
        BeanUtils.copyProperties(product,p);
        p.setViewCount(0);
        p.setCreated(new Date());
        mapper.insert(p);
    }

    @RequestMapping("selectForAdmin")
    public List<ProductAdminVO> selectForAdmin(){
        return mapper.selectForAdmin();
    }

    @Value("${dirPath}")
    String dirPath;
    @RequestMapping("/delete")
    public void delete(int id){
        // 查询商品图片路径
        String url = mapper.selectUrlById(id);
        new File(dirPath+url).delete();
        mapper.deleteById(id);
    }

    @RequestMapping("/selectForIndex")
    public List<ProductIndexVO> selectForIndex(){
        return mapper.selectForIndex();
    }

    @RequestMapping("/selectForTop")
    public List<ProductTopVO> selectForTop(){
        return mapper.selectForTop();
    }

    @RequestMapping("/selectById")
    public ProductDetailVO selectById(int id){
        return mapper.selectById(id);
    }

    @RequestMapping("selectByCid")
    public List<ProductIndexVO> selectByCid(int id){
        return mapper.selectByCid(id);
    }

    @RequestMapping("/selectByWd")
    public List<ProductIndexVO> selectByWd(String wd){
        return mapper.selectByWd(wd);
    }

    @RequestMapping("/selectForUpdateById")
    public ProductUpdateVO selectForUpdateById(int id){
        return mapper.selectForUpdateById(id);
    }

    @RequestMapping("/update")
    public void update(@RequestBody ProductUpdateDTO product){
        mapper.update(product);
    }
}
