package org.pcdd.javase.university.javaweb第2次和第3次作业;

import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * JDBC工具类，仿照 Spring JdbcTemplate
 *
 * @author pcdd
 * date 2021/4/14 10:33
 */
public class JdbcUtils {

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/sams?"
            + "serverTimezone=Asia/Shanghai"
            + "&useUnicode=true"
            + "&characterEncoding=utf8"
            + "&useSSL=true";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "qwe123";

    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    /**
     * 初始化连接
     */
    private void init() {
        try {
            // 可省略
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        } catch (ClassNotFoundException e) {
            System.err.println("驱动加载异常：" + e.getMessage());

        } catch (SQLException e) {
            System.err.println("获取Connection对象失败：" + e.getMessage());
        }
    }

    /**
     * 释放资源
     */
    private void close() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.err.println("ResultSet对象释放失败：" + e.getMessage());
            }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                System.err.println("PreparedStatement对象释放失败：" + e.getMessage());
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Connection对象释放失败：" + e.getMessage());
            }
        }
    }

    /**
     * 创建PreparedStatement接口实例
     */
    private void initPreparedStatement(String sql, String... args) {
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
        } catch (SQLException e) {
            System.err.println("初始化PreparedStatement对象失败：" + e.getMessage());
        }
    }

    /**
     * 核心方法：执行查询sql
     *
     * @param sql  查询sql语句
     * @param args 字段对应的值
     * @return 查询结果集
     */
    public List<Map<String, Object>> query(String sql, String... args) {
        try {
            init();
            initPreparedStatement(sql, args);

            ResultSet resultSet = preparedStatement.executeQuery();
            return JsonUtils.toList(resultSet);

        } catch (SQLException e) {
            System.err.println("DQL执行失败：" + e.getMessage());
        }

        return null;
    }

    /**
     * 核心方法：执行增删改sql
     *
     * @param sql  增删改sql语句
     * @param args 字段对应的值
     * @return 影响的行属
     */
    public int update(String sql, String... args) {
        init();
        initPreparedStatement(sql, args);

        int count = -1;
        try {
            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("DML执行失败：" + e.getMessage());
        } finally {
            close();
        }

        return count;
    }

    /**
     * 可以用于执行任何SQL语句，一般用于执行DDL语句
     */
    public void execute(String sql, String... args) {
        init();
        initPreparedStatement(sql, args);
        try {
            // execute（）只有执行select等带有ResultSet object返回结果集时它的返回值才是true
            preparedStatement.execute(sql, args);
        } catch (SQLException e) {
            System.err.println("SQL执行失败：" + e.getMessage());
        } finally {
            close();
        }
    }


}
