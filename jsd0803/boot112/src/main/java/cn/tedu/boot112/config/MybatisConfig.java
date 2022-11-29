package cn.tedu.boot112.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.boot112.mapper")
public class MybatisConfig {
}
