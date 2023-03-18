package org.pcdd.javase.tutorial.chapter15_常用类库.base64;

import java.util.Base64;
import java.util.UUID;

class StringUtil {
    // 公共的盐值
    private static final String SALT = "Spring";
    // 加密的次数
    private static final int REPEAT = 5;

    /**
     * Base64加密处理
     *
     * @param str 要加密的字符串
     * @return 加密后的数据
     */
    public static String encode(String str) {
        // 盐值对外不公布
        String temp = str + "{" + SALT + "}";
        // 将字符串变为字节数组
        byte[] data = temp.getBytes();
        for (int i = 0; i < REPEAT; i++) {
            data = Base64.getEncoder().encode(data);
        }
        // 返回加密后的数据
        return new String(data);
    }

    public static String decode(String str) {
        byte[] data = str.getBytes();
        for (int i = 0; i < REPEAT; i++) {
            data = Base64.getDecoder().decode(data);
        }
        // 删除盐值格式
        return new String(data).replaceAll("\\{\\w+}", "");
    }
}

public class Main {
    public static void main(String[] args) {
        String str = StringUtil.encode("www.work.pcdd");
        System.out.println(str);
        System.out.println(StringUtil.decode(str));

        System.out.println("UUID:" + UUID.randomUUID());

    }
}
