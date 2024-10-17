package org.pcdd.javase.随机练习;

import java.sql.*;

public class Jdbc {
    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/stu1821?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
    public static final String DB_USER = "root";
    public static final String DB_PWD = "root";

    public static Connection con = null;
    public static ResultSet rs = null;
    public static PreparedStatement pstmt = null;

    public static void init() {
        try {
            Class.forName(DB_DRIVER);
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int update(String sql) {
        int count = 0;
        try {
            pstmt = con.prepareStatement(sql);
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public static ResultSet selectSql(String sql) {
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    public static void close() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                rs = null;
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                pstmt = null;
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                con = null;
            }
        }
    }
}
