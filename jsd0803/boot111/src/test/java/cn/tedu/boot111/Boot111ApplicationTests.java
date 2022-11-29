package cn.tedu.boot111;

import cn.tedu.boot111.entity.Emp;
import cn.tedu.boot111.mappers.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Boot111ApplicationTests {

    @Autowired(required = false)
    EmpMapper mapper;
    @Test
    void contextLoads() {
    }

    @Test
    void test1(){
        Emp emp = new Emp();
        emp.setJob("氛围组组长");
        emp.setName("Tom");
        emp.setSalary(1800.00);
        mapper.insert(emp);
    }

    @Test
    void test2(){
        Emp emp1 = new Emp();
        emp1.setJob("氛围组组员");
        emp1.setName("Jerry");
        emp1.setSalary(1500.00);

        Emp emp2 = new Emp();
        emp2.setJob("氛围组组员");
        emp2.setName("Anne");
        emp2.setSalary(1500.00);

        Emp emp3 = new Emp();
        emp3.setJob("氛围组组员");
        emp3.setName("Jason");
        emp3.setSalary(1500.00);

        List<Emp> list = new ArrayList<>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);

        mapper.insertMutil(list);
    }

    @Test
    void test3(){
        mapper.deleteById(3);
    }

    @Test
    void test4(){
        Integer[] integer = {2,4};
        int delete = mapper.delete(integer);
        System.out.println(delete);
    }

    @Test
    void test5(){
        Emp emp1 = new Emp();
        emp1.setJob("总经理");
        emp1.setSalary(15000.00);
        emp1.setId(5);
        mapper.update(emp1);
    }

    @Test
    void test6(){
        System.out.println(mapper.selectById(4));
    }

    @Test
    void test7(){
        System.out.println(mapper.select());
    }

}
