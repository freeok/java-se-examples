package org.pcdd.javase.net;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 复习
 *
 * @author pcdd
 * date 2020/12/29 22:37
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Document document = Jsoup.connect("https://news.sina.com.cn/")
                .timeout(10000)
                .ignoreContentType(true)
                .get();

        System.out.println(document.getElementById("syncad_1").getElementsByTag("a"));
    }
}
