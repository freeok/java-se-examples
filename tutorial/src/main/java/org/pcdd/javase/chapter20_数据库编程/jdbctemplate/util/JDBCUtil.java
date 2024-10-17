package org.pcdd.javase.chapter20_数据库编程.jdbctemplate.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

public class JDBCUtil {
    public static DataSource ds = null;


    static {
        // 定义配置文件
        Properties pro = new Properties();
        // 加载配置文件
        try {
            pro.load(JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            // 数据库连接池为阿里的Druid
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }


}
