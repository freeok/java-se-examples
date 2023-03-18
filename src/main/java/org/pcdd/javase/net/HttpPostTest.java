package org.pcdd.javase.net;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;

public class HttpPostTest {
    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://www.itcast.cn");
        CloseableHttpResponse resp = httpClient.execute(httpPost);
        if (resp.getCode() == 200) {
            String content = EntityUtils.toString(resp.getEntity(), "utf-8");
            System.out.println(content);

            resp.close();
            httpClient.close();
        }
    }
}
