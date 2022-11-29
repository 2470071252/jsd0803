package cn.tedu.boot101.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.boot101.mapper")
public class MybatisConfig {

}
