package cn.tedu.boot11.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.boot11.mapper")
public class MybatisConfig {
}
