package cn.tedu.coolshark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
// 通过此注解扫描当前包以及子包中的过滤器并初始化运行
@ServletComponentScan

@SpringBootApplication
public class CoolsharkApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoolsharkApplication.class, args);
    }

}
