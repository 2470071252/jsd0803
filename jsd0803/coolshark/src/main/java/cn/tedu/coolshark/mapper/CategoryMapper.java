package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.pojo.entity.Category;

import java.util.List;

public interface CategoryMapper {

    List<Category> select();

    void deleteById(int id);

    void insert(String name);

    void update(Category category);
}
