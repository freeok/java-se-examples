package org.pcdd.javase.chapter16_IO编程.随机练习;

import java.io.*;

/**
 * date 2020/12/15
 */
public class Ex01 {
    private static String filePath = "e:" + File.separator + "pcdd" + File.separator + "info.txt";
    private static long start;
    private static long end;

    public static void main(String[] args) throws Exception {
        File file = new File(filePath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();

        // 写文件
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        start = System.currentTimeMillis();
        // 写入多次
        for (int i = 0; i < Short.MAX_VALUE; i++) {
            bos.write(("这是第" + (i + 1) + "行文字\r\n").getBytes());
        }
        end = System.currentTimeMillis();
        System.out.println("写文件耗时：" + (end - start) + "ms");

        // 读文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        byte[] data = new byte[1024];
        int len = 0;
        StringBuffer sb = new StringBuffer();
        start = System.currentTimeMillis();
        while ((len = bis.read(data)) != -1) {
            sb.append(new String(data, 0, len));
        }
        end = System.currentTimeMillis();
        System.out.println("读文件耗时：" + (end - start) + "ms");
        System.out.println(sb);


    }
}
