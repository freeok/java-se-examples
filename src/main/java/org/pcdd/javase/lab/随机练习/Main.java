package org.pcdd.javase.lab.随机练习;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    // 只有登录成功，程序才结束
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("登录案例开始");

        boolean flag = true;
        int count = 0;

        while (flag) {
            System.out.println("请输入账号：");
            String id = sc.nextLine().trim();
            System.out.println("请输入密码：");
            String pwd = sc.nextLine().trim();

            if ("".equals(id) || "".equals(pwd)) {
                System.out.println("用户名或密码不能为空！");
            } else {
                User user = new User();
                user.setId(id);
                user.setPwd(pwd);

                UserDao obj = new UserDaoImpl();
                if (obj.login(user.getId(), user.getPwd())) {
                    try {
                        Jdbc.init();
                        ResultSet rs = Jdbc.selectSql("select sname from stu where sid='" + user.getId() + "'");
                        rs.next();
                        String name = rs.getString("sname");
                        Jdbc.close();
                        System.out.println("登录成功！\n姓名：" + name);
                        flag = false;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("用户名或密码错误！第" + (++count) + "次错误！");
                }
            }
        }

    }
}
