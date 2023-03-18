package org.pcdd.javase.university.javaweb第2次和第3次作业;

/**
 * @author pcdd
 * date 2021/4/14 10:33
 */
public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("张三，小明，李四，小明".indexOf("小明"));


       /* JdbcUtils jdbcUtils = new JdbcUtils();

        String rSql1 = "select * from student";
        String rSql2 = "select * from student where sname = ?";
        String cSql = "insert into student values(?,?,?,?)";
        String uSql = "update student set clazz = ? where sno = ?";
        String dSql = "delete from student where sno = ?";

        // 查询
        System.out.println(jdbcUtils.query(rSql2, "王明阳"));
        System.out.println(jdbcUtils.query(rSql1));*/

        // 添加
        // System.out.println(jdbcUtils.update(cSql, "5672", "测试姓名", "测试班级", "测试院系"));

        // 修改
        // System.out.println(jdbcUtils.update(uSql, "计算机科学与技术1841", "5672"));

        // 删除
        // System.out.println(jdbcUtils.update(dSql, "5672"));

        // 创建test表
        // jdbcUtils.execute("create table test(id char(10) primary key)");
        // 将字段id重命名为sid，并修改数据类型为int
        // jdbcUtils.execute("alter table test change id sid int");

    }

}
