package org.pcdd.javase.rule34vault;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static final String USER_ID = "66608";
    public static final String detailsUrl = "https://rule34vault.com/post/";
    public static final Proxy PROXY = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7897));

    public static void main(String[] args) {
        Set<String> urls = getBookmarks();
        System.out.println("书签数量 " + urls.size());

        ExecutorService executor = Executors.newFixedThreadPool(2);
        // 爬取书签图片
        for (String url : urls) {
            executor.execute(() -> crawl(url));
        }

        executor.shutdown();
        executor.close();
    }

    @SneakyThrows
    public static void crawl(String url) {
        String s = HttpUtil.createGet(url)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.5410.0 Safari/537.36")
                .timeout(3000)
                .execute()
                .body();

        Document document = Jsoup.parse(s);
        Elements img = document.select("body > app-root > app-root-layout-page > div > mat-sidenav-container > mat-sidenav-content > app-post-page > app-page > app-post-page-content > app-post-image > div > img");
        String imgSrc = img.attr("src").replace(".small.jpg", ".jpg");
        System.out.println("正在爬取 " + imgSrc);
        download(imgSrc, STR."E:/Downloads/403/image/test/\{FileUtil.getName(imgSrc)}");
    }

    /**
     * 获取书签里的全部 url
     */
    public static Set<String> getBookmarks() {
        int skip = 0; // 从第几条开始
        int take = 100; // 查询数
        Set<String> ids = new LinkedHashSet<>();

        while (true) {
            String s = reqBookmarks(skip, take);
            JSONObject entries = JSONUtil.parseObj(s);
            int totalCount = entries.get("totalCount", Integer.class);
            Object items = entries.get("items");

            for (Object o : JSONUtil.parseArray(items)) {
                String id = JSONUtil.parseObj(o).get("id", String.class);
                ids.add(detailsUrl + id);
            }

            skip += take;
            if (skip >= totalCount) break;
        }

        return ids;
    }

    /**
     * 调用获取书签接口
     */
    public static String reqBookmarks(int skip, int take) {
        String bookmarkUrl = STR."https://rule34vault.com/api/v2/post/search/bookmarked/\{USER_ID}";
        // 经测试，一次最多返回 100 条
        String body = STR."""
                {
                    "Skip": \{skip},
                    "take": \{take},
                    "CountTotal": true
                }""";
        HttpResponse resp = HttpUtil.createPost(bookmarkUrl)
                .contentType("application/json")
                .body(body)
                .execute();

        return resp.body();
    }

    /**
     * 下载图片或视频到指定位置
     */
    public static void download(String url, String dest) {
        HttpRequest req = HttpRequest.get(url)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.5410.0 Safari/537.36")
                .timeout(3000);
        req.setProxy(PROXY);
        FileUtil.writeBytes(req.execute().bodyBytes(), dest);
    }

}
