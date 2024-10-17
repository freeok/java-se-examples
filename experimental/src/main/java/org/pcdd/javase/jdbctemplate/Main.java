package org.pcdd.javase.jdbctemplate;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        JdbcUtils.init();

        ResultSet rs = JdbcUtils.query("SELECT * FROM student");
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        System.out.println("columnCount = " + columnCount);
        System.out.println("metaData = " + metaData);

        while (rs.next()) {
            Object o1 = rs.getObject(1);
            Object o2 = rs.getObject(2);
            Object o3 = rs.getObject(3);
            System.out.println(o1 + "\t" + o2 + "\t" + o3);
        }

        JdbcUtils.close();
    }
}
