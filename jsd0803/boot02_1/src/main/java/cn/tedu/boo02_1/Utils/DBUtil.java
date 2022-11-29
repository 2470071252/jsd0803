package cn.tedu.boo02_1.Utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    private static DruidDataSource dds;

    static {
        init();
    }

    private static void init() {
        dds = new DruidDataSource();
        dds.setMaxActive(20);
        dds.setUsername("root");
        dds.setPassword("root");
        dds.setUrl("jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true");
        dds.setInitialSize(5);
    }

    public static Connection getConnection() throws SQLException {
        return dds.getConnection();
    }


}
