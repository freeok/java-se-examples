package org.pcdd.javase.net;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

public class HttpGetTest {
    public static void main(String[] args) {
        // 获取HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建HttpGet对象，设置url访问地址
        HttpGet httpGet = new HttpGet("http://www.itcast.cn");

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
        } catch (ParseException e) {
            throw new RuntimeException(e);
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
