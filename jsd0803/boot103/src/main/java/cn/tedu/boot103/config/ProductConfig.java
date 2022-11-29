package cn.tedu.boot103.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.boot103.mapper")
public class ProductConfig {
}
