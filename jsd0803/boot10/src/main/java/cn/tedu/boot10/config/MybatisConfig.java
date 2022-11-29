package cn.tedu.boot10.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 设置当前类为配置类，程序运行时会自动加载此类
@MapperScan("cn.tedu.boot10.mapper")  // Mapper扫描注解，在注解里面设置Mapper的包，这样会自动从
// 包里找到Mapper接口 告诉编译器去哪找Mapper
public class MybatisConfig {

}
