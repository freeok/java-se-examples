package org.pcdd.javase.tutorial.chapter20_数据库编程;

import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) throws Exception {
        long t1 = System.currentTimeMillis();
        JdbcUtils.init();

        ResultSet rs = JdbcUtils.query("select * from course");
        while (rs.next()) {
            System.out.println(rs.getString(1) + "\t"
                    + rs.getString(2) + "\t"
                    + rs.getString(3) + "\t"
            );
        }

        int i = JdbcUtils.update("update student set Sname = ? where Sno = ?", "张山峰", 202001);
        System.out.println("i = " + i);

        long t2 = System.currentTimeMillis();
        System.out.println("总耗时：" + (t2 - t1) + "ms");
        System.out.println(JdbcUtils.ds);
    }

}
