package cn.tedu.boot111.mappers;

import cn.tedu.boot111.entity.Emp;

import java.util.List;

public interface EmpMapper {
    // 添加一个员工
    void insert(Emp emp);

    // 添加多个员工
    int insertMutil(List<Emp> list);

    // 通过id删除员工
    void deleteById(int id);

    // 通过id删除多个员工
    int delete(Integer[] ids);

    // 动态修改
    int update(Emp emp);

    // 通过id查询一个员工信息
    Emp selectById(int id);

    //查询所有员工信息
    List<Emp> select();

}
