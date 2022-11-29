package cn.tedu.boot11.mapper;

import cn.tedu.boot11.entity.Product;

import java.util.List;

public interface ProductMapper {
    int count();

    // 批量删除 int返回值代表生效的行数
    int deleteByIds1(List<Integer> ids);
    int deleteByIds2(Integer[] ids);
    int deleteByIds3(Integer... ids);

    // insert into product values(null,a,b,c),(null,aa,bb,cc),...;
    // 批量插入
    int insertProducts(List<Product> list);

    // 动态修改
    void dynamicUpdate(Product p);

    //查询相关
    List<Product> select();
    Product selectById(int id);
}
