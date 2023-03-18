package org.pcdd.javase.net;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

public class CrawlerFirst {

    public static void main(String[] args) throws Exception {
        // 1.打开浏览器，创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 2.输入网址,发起get请求，创建HttpGet对象
        HttpGet httpGet = new HttpGet("https://www.bilibili.com/");

        // 3.按回车，发起请求，返回响应，使用HttpClient对象发起请求
        CloseableHttpResponse response = httpClient.execute(httpGet);

        // 4.解析响应，获取数据
        // 判断状态码是否是200
        if (response.getCode() == 200) {
            HttpEntity httpEntity = response.getEntity();
            String content = EntityUtils.toString(httpEntity, "utf-8");

            System.out.println(content);
        }

    }
}
