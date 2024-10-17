package org.pcdd.javase.net;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class HttpPostParamTest {
    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("https://www.baidu.com/s");

        // https://www.baidu.com/s?wd=sqnu
        // 声明List集合，封装表单中的参数
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("wd", "sqnu"));

        // 创建表单的Entity对象，第一个参数就是封装好的表单数据，第二个参数就是编码
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params);

        // 设置表单的Entity对象到Post请求中
        httpPost.setEntity(formEntity);

        CloseableHttpResponse resp = httpClient.execute(httpPost);

        if (resp.getCode() == 200) {
            String content = EntityUtils.toString(resp.getEntity(), "utf-8");
            System.out.println(content.length());

            resp.close();
            httpClient.close();
        }
    }
}
