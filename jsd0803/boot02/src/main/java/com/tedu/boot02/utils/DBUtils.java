package com.tedu.boot02.utils;

import com.alibaba.druid.pool.DruidDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtils {
    /*
    static {
        try {
            //DBUtil第一次被加载时，加载数据库驱动类 "com.mysql.cj.jdbc.Driver"
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testUser?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
                "root",
                "root");
    }
    */
    private static DruidDataSource dds;
    static {
        init();
    }
    private static void init(){
        dds = new DruidDataSource();//实例化连接池
        //设置连接池基本参数:数据库连接,用户名,密码,初始连接数,最大连接数等
        dds.setUsername("root");//设置数据库用户名
        dds.setPassword("root");//设置数据库密码
        //设置数据库连接,阿里的连接池会根据该连接分析数据库并自行选择驱动类
        dds.setUrl("jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true");
        dds.setInitialSize(5);//设置初始连接数
        dds.setMaxActive(20);//设置最大连接数
    }
    public static Connection getConnection() throws SQLException {
      /*
        连接池返回的连接是对驱动包中提供的连接的2次封装。
        该连接的close()方法并非将连接关闭，而是将连接还给连接池。
       */
        return dds.getConnection();
    }
}
