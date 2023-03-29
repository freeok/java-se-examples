package org.pcdd.javase.tutorial.chapter20_数据库编程;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC工具类
 *
 * @author pcdd
 * date 2020/12/19 22:00
 */
@Slf4j
public class JdbcUtils {

    private static DataSource ds = null;
    private static Connection con = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    static {
        init();
    }

    private JdbcUtils() {
    }

    public static void init() {
        Properties pro = new Properties();
        try {
            pro.load(JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            Class.forName(pro.getProperty("driverClassName"));
            ds = DruidDataSourceFactory.createDataSource(pro);
            con = ds.getConnection();
        } catch (IOException e) {
            log.error("jdbc配置文件加载失败：{}", e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            log.error("数据库驱动加载失败：{}", e.getMessage(), e);
        } catch (Exception e) {
            log.error("JdbcUtils初始化失败：{}", e.getMessage(), e);
        }
    }

    /**
     * 释放资源
     */
    private static void close() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.error("ResultSet对象释放失败：{}", e.getMessage(), e);
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                log.error("PreparedStatement对象释放失败：{}", e.getMessage(), e);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                log.error("Connection对象释放失败：{}", e.getMessage(), e);
            }
        }
    }

    /**
     * select
     *
     * @return 查询结果集
     */
    public static ResultSet query(String sql, Object... args) {
        try {
            pstmt = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i + 1, args[i]);
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            log.error("SQL查询失败：{}", e.getMessage(), e);
        } finally {
            close();
        }
        return rs;
    }

    /**
     * insert, update, delete
     *
     * @return 影响的行属
     */
    public static int update(String sql, Object... args) {
        try {
            pstmt = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i + 1, args[i]);
            }
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            log.error("DML执行失败：{}", e.getMessage(), e);
        } finally {
            close();
        }
        return 0;
    }

    /**
     * 可以用于执行任何SQL语句，一般用于执行DDL语句
     */
    public static void execute(String sql, String... args) {
        try {
            // execute（）只有执行select等带有ResultSet object返回结果集时它的返回值才是true
            pstmt.execute(sql, args);
        } catch (SQLException e) {
            log.error("SQL执行失败：{}", e.getMessage(), e);
        } finally {
            close();
        }
    }

}
