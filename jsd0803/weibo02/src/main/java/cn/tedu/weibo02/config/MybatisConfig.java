package cn.tedu.weibo02.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.weibo02.mapper")
public class MybatisConfig {
}
