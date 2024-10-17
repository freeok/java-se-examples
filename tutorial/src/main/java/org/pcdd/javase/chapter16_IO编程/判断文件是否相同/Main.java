package org.pcdd.javase.chapter16_IO编程.判断文件是否相同;

import java.io.*;

/**
 * @author pcdd
 * create at 2023/04/23 18:06
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(fileContentEquals(
                new File(""),
                new File("")
        ));
    }

    private static boolean fileContentEquals(File f1, File f2) {
        // 文件不存在
        if (!f1.exists() || !f2.exists()) {
            return false;
        }
        // 大小不相等
        if (f1.length() != f2.length()) {
            return false;
        }
        // 逐字节比较文件内容
        try {
            BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream(f1));
            BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream(f2));
            while (true) {
                int ch1 = bis1.read();
                int ch2 = bis2.read();
                if (ch1 == -1 || ch2 == -1) {
                    break;
                }
                if (ch1 != ch2) {
                    return false;
                }
            }
            bis1.close();
            bis2.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        return true;
    }

}
