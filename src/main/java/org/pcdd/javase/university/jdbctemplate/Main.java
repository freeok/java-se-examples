package org.pcdd.javase.university.jdbctemplate;

import org.pcdd.javase.university.jdbctemplate.dao.AdminDao;
import org.pcdd.javase.university.jdbctemplate.dao.AdminDaoImpl;
import org.pcdd.javase.university.jdbctemplate.dao.UserDao;
import org.pcdd.javase.university.jdbctemplate.dao.UserDaoImpl;
import org.pcdd.javase.university.jdbctemplate.entity.Admin;
import org.pcdd.javase.university.jdbctemplate.entity.User;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserDao ud = new UserDaoImpl();
        User user = new User();
        AdminDao ad = new AdminDaoImpl();
        Admin admin = new Admin();
        Scanner sc = new Scanner(System.in);
        String code;
        boolean flag = true; // 控制程序结束
        boolean loginInfo = true; // 登录信息只显示一次

        System.out.println("username:");
        admin.setAid(sc.nextLine());
        System.out.println("password:");
        admin.setPwd(sc.nextLine());

        while (flag) {
            // 管理员登录，成功后开始进行数据库的操作
            if (ad.login(admin.getAid(), admin.getPwd())) {
                // 获取管理员的姓名
                if (loginInfo) {
                    System.out.println("欢迎你，管理员" + ad.getAdminById(admin.getAid()).get(0).getAname().charAt(0) + "先生");
                    loginInfo = false;
                }

                System.out.println("增加用户按请1\t删除用户请按2\t修改用户请按3\t显示所有用户请按4\t查询用户请按5\t退出请按输入exit");
                code = sc.nextLine().trim();
                switch (code) {
                    case "1":
                        System.out.println("请输入学号：");
                        user.setSid(sc.nextLine());
                        System.out.println("请输入用户名：");
                        user.setSname(sc.nextLine());
                        System.out.println("请输入密码：");
                        user.setPwd(sc.nextLine());
                        if (ud.add(user.getSid(), user.getSname(), user.getPwd())) {
                            System.out.println(user.getSid() + "添加成功！");
                        } else {
                            System.out.println("error!");
                        }
                        break;
                    case "2":
                        System.out.println("请输入要删除用户的学号：");
                        user.setSid(sc.nextLine());
                        if (ud.delete(user.getSid())) {
                            System.out.println(user.getSid() + "删除成功");
                        } else {
                            System.out.println("error!");
                        }
                        break;
                    case "3":
                        System.out.println("请输入要修改用户的学号：");
                        user.setSid(sc.nextLine());
                        System.out.println("请输入新用户名");
                        user.setSname(sc.nextLine());
                        System.out.println("请输入新密码");
                        user.setPwd(sc.nextLine());
                        System.out.println("请再输入一次新密码");
                        String str = sc.nextLine();
                        if (str.equals(user.getPwd())) {
                            if (ud.update(user.getSid(), user.getSname(), user.getPwd())) {
                                System.out.println(user.getSid() + "修改成功！");
                            } else {
                                System.out.println("error!");
                            }
                        } else {
                            System.out.println("两次密码输入不一致！");
                        }
                        break;
                    case "4":
                        for (User list : ud.getUserAll()) {
                            System.out.println("学号：" + list.getSid() + "\t姓名：" + list.getSname());
                        }
                        break;
                    case "5":
                        System.out.println("请输入要查询用户的学号：");
                        user.setSid(sc.nextLine());
                        List<User> list = ud.getUserById(user.getSid());
                        if (list.size() != 0) {
                            System.out.println("学号：" + list.get(0).getSid() + "\t姓名：" + list.get(0).getSname());
                        } else {
                            System.out.println("查无此人！");
                        }
                        break;
                    case "exit":
                        flag = false;
                        System.out.println("bye bye");
                        break;
                    default:
                        System.out.println("请根据提示键入！");
                }
            } else {
                System.out.println("管理员账号或密码错误！");
                System.exit(0);
            }
        }

    }
}
