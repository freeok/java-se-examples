package org.pcdd.javase.tutorial.chapter20_数据库编程;

import com.alibaba.druid.pool.DruidDataSourceFactory;

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
public class JdbcUtils {

    public static DataSource ds = null;
    public static Connection con = null;
    public static PreparedStatement pstmt = null;
    public static ResultSet rs = null;

    static {
        init();
    }

    public static void init() {
        Properties pro = new Properties();
        try {
            pro.load(JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            Class.forName(pro.getProperty("driverClassName"));
            ds = DruidDataSourceFactory.createDataSource(pro);
            con = ds.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("jdbc配置文件加载失败！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("数据库驱动加载失败！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("创建数据源失败！");
        }
    }

    public static ResultSet query(String sql, Object... args) {
        try {
            pstmt = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i + 1, args[i]);
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static int update(String sql, Object... args) {
        try {
            pstmt = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i + 1, args[i]);
            }
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
