package org.pcdd.javase.net;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.net.URIBuilder;

import java.io.IOException;

public class HttpGetParamTest {
    public static void main(String[] args) throws Exception {
        // 获取HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // https://www.baidu.com/s?wd=商丘师范学院
        // 创建URIBuilder对象
        URIBuilder uriBuilder = new URIBuilder("https://www.baidu.com/s");
        // 设置参数
        uriBuilder.setParameter("wd", "商丘师范学院");

        // 创建HttpGet对象，设置url访问地址
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        System.out.println("发起的请求地址：" + httpGet);

        // 使用HttpClient发起请求，获取response
        CloseableHttpResponse resp = null;
        try {
            resp = httpClient.execute(httpGet);
            // 解析响应
            if (resp.getCode() == 200) {
                String content = EntityUtils.toString(resp.getEntity(), "utf-8");
                System.out.println(content.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                resp.close();
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
