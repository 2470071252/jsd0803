package cn.tedu.boot01.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class HelloController {
    //localhost:8080/hello
//    @RequestMapping("/hello")
//    public void user(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        // 设置相应类型
//        response.setContentType("text/html;charset=utf-8");
//        // 得到输出对象 异常抛出
//        PrintWriter pw = response.getWriter();
//        // 给客户端输出相应内容
//        pw.println("恭喜你测试成功");
//        // 关闭资源
//        pw.close();
//    }
    @RequestMapping("/hello")
    @ResponseBody  // 该注解能够通过返回值的方式给客户端响应数据
    public String hello(){
        return "恭喜你新注解测试成功！";
    }
}
