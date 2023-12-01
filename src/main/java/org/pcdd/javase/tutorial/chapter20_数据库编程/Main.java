package org.pcdd.javase.tutorial.chapter20_数据库编程;

public class Main {

    public static void main(String[] args) throws Exception {
        // 查询
        System.out.println(JdbcUtils.query("select * from student where name = ?",
                "王焱"));

        // 添加
        System.out.println(JdbcUtils.update("insert into student values(?,?,?,?)",
                "2018", "测试姓名", "测试班级", "测试院系"));

        // 修改
        System.out.println(JdbcUtils.update("update student set clazz = ? where sno = ?",
                "计算机科学与技术1841", "2018"));

        // 删除
        System.out.println(JdbcUtils.update("delete from student where sno = ?",
                "2018"));

        // 创建test表
        JdbcUtils.execute("create table jdbc_test(id char(10) primary key)");

        // 将字段id重命名为sid，并修改数据类型为int
        JdbcUtils.execute("alter table jdbc_test change id sid int");
    }

}
