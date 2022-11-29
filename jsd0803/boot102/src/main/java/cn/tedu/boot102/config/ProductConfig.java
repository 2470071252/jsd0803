package cn.tedu.boot102.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.boot102.mapper")
public class ProductConfig {

}
