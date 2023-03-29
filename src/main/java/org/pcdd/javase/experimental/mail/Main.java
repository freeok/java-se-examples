package org.pcdd.javase.experimental.mail;

import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @ClassName: Sendmail
 * @Description: 发送一封只包含文本的简单邮件
 */
public class Main {
    private static String mailFrom = null;// 指明邮件的发件人
    private static String password_mailFrom = null;// 指明邮件的发件人登陆密码
    private static String mailTo = null;    // 指明邮件的收件人
    private static String mailTittle = null;// 邮件的标题
    private static String mailText = null;    // 邮件的文本内容
    private static String mail_host = null;    // 邮件的服务器域名

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        mailFrom = "ppcdd@foxmail.com";
        password_mailFrom = "qhoicvrzkufkbgfa";
        mailTo = "1907263405@qq.com";
        // mailTo = "1271713872@qq.com";
        mailTittle = "今天有2门课";
        mailText = "<span style='font-size:18px;color:red;'>课程名：算法设计与分析<br/>上课时间：14:30<br/>上课地点：行房楼-301"
                + "<br/>发送时间："
                + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
                + "</span>";
        mail_host = "smtp.qq.com";

        Properties prop = new Properties();
        prop.setProperty("mail.host", mail_host);
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");

        // 使用JavaMail发送邮件的5个步骤

        // 1、创建session
        Session session = Session.getInstance(prop);
        // 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        // 2、通过session得到transport对象
        Transport ts = session.getTransport();
        // 3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
        ts.connect(mail_host, mailFrom, password_mailFrom);
        // 4、创建邮件
        Message message = createSimpleMail(session, mailFrom, mailTo, mailTittle, mailText);
        // 5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }

    /**
     * @Method: createSimpleMail
     * @Description: 创建一封只包含文本的邮件
     */
    public static MimeMessage createSimpleMail(Session session, String mailfrom, String mailTo, String mailTittle,
                                               String mailText) throws Exception {
        // 创建邮件对象
        MimeMessage message = new MimeMessage(session);
        // 指明邮件的发件人,可以指定别名
        message.setFrom(new InternetAddress(mailfrom, "pcdd.work", "UTF-8"));
        // 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
        // 邮件的标题
        message.setSubject(mailTittle);
        // 邮件的文本内容
        message.setContent(mailText, "text/html;charset=UTF-8");
        // 返回创建好的邮件对象
        return message;
    }
}
