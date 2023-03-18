package org.pcdd.javase.lab.mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Test {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        mySend();
        long end = System.currentTimeMillis();
        // 一般是10秒左右，很慢
        System.out.println(end - start + "ms");
    }

    // 第二种发送邮件的方法
    public static void mySend() {
        try {
            SimpleEmail email = new SimpleEmail(); // 构造一个mail对象
            email.setHostName("smtp.qq.com");// 设置主机名
            email.setAuthenticator(new DefaultAuthenticator("ppcdd@foxmail.com", "qhoicvrzkufkbgfa"));
            email.setSSLOnConnect(true);
            email.setFrom("ppcdd@foxmail.com", "hi");// 设置发送人
            email.addTo("1907263405@qq.com", "li");// 设置发对象
            email.setSubject("邮件测试");// 设置主题
            String content = "测试内容";// 内容
            email.setCharset("UTF-8");// 设置发送使用的字符集
            email.setContent(content, "text/html;charset=utf-8");// 设置内容
            email.send();// 发送
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
