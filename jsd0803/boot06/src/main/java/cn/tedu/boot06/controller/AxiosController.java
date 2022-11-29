package cn.tedu.boot06.controller;

import cn.tedu.boot06.entity.Product;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AxiosController {
    @RequestMapping("/helloAxios")
    public String helloAxios(){
        return "测试成功";
    }

    @RequestMapping("/helloGet")
    public String helloGet(String info,int age){
        return "测试成功，info="+info+","+"age="+age;
    }

    // 如果客户端发出异步post请求并且提交的是自定义对象
    // 接收参数时必须添加@RequestBody注解
    @RequestMapping("/helloPost")
    public String helloPost(@RequestBody Product p){
        return p.toString();
    }

}
