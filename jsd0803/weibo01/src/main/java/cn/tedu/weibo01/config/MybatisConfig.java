package cn.tedu.weibo01.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.weibo01.mapper")
public class MybatisConfig {
}
