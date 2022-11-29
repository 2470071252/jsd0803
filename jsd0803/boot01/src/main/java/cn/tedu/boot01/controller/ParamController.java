package cn.tedu.boot01.controller;

import cn.tedu.boot01.entity.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ParamController {
    // 第一种传参方式
    @RequestMapping("/p1")
    @ResponseBody
    public String p1(HttpServletRequest request){
        String info = request.getParameter("info");
        return "参数："+info;
    }

    // 第二种传参方式(通过声明的方式),能够自动转换参数类型
    // 在BirdBoot项目中age参数用的第一种传参方式，需要用Integer.parseInt()转换
    @RequestMapping("/p2")
    @ResponseBody
    public String p2(String info,int age){
        return "参数"+info+","+age;
    }

    // 第三种传参方式(以对象的形式),一般含有两种以上的参数用该方式
    // 会自动调用set方法，把接收到的参数放入。（类的属性名要和form表单中的name一致）
    @RequestMapping("/p3")
    @ResponseBody
    public String p3(Emp emp){
        return "参数："+emp.toString();
    }

}
