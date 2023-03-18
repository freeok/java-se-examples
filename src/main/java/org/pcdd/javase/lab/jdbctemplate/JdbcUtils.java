package org.pcdd.javase.lab.jdbctemplate;

import java.sql.*;

/**
 * jdbc回忆练习
 *
 * @author pcdd
 * 2020/11/7 20:38
 */
public class JdbcUtils {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jdbc_test?"
            + "characterEncoding=utf8"
            + "&useSSL=false"
            + "&serverTimezone=Asia/Shanghai"
            + "&rewriteBatchedStatements=true"
            + "&allowPublicKeyRetrieval=true";

    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "root";
    private static Connection con;
    private static PreparedStatement pstmt;

    private JdbcUtils() {
    }

    /**
     * 初始化连接
     */
    public static void init() {
        try {
            con = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(con);
    }

    public static void close() {
        try {
            if (con != null) {
                con.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ResultSet query(String sql, String... args) {
        try {
            pstmt = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i + 1, args[i]);
            }
            return pstmt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static boolean update(String sql, String... args) {
        int result = 0;
        try {
            pstmt = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i + 1, args[i]);
            }
            result = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result > 0;
    }


}
