package org.pcdd.javase.rule34vault;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
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

public class Rule34vault {

    public static final String USER_ID = "66608";
    public static final String detailsUrl = "https://rule34vault.com/post/";
    public static final Proxy PROXY = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7897));
    public static final String destPath = "E:/Downloads/403/rule34vault/";
    public static final int timeout = 60_000;

    @SneakyThrows
    void main() {
        Set<String> urls = getBookmarks();
        System.out.println("云书签数量 " + urls.size());
        // 去重，本地已存在的不再下载
        urls.removeIf(url -> FileUtil.exist(destPath, FileUtil.getName(url) + "\\.(jpg|mp4|png|gif)"));
        System.out.println("待下载数量 " + urls.size());

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        // 爬取书签图片
        for (String url : urls) {
            executor.execute(() -> crawl(url));
            Thread.sleep(RandomUtil.randomInt(50, 300));
        }

        executor.shutdown();
        executor.close();
    }

    @SneakyThrows
    public static void crawl(String url) {
        String s = HttpUtil.createGet(url)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.5410.0 Safari/537.36")
                .timeout(timeout)
                .execute()
                .body();

        Document document = Jsoup.parse(s);
        Elements img = document.select("body > app-root > app-root-layout-page > div > mat-sidenav-container > mat-sidenav-content > app-post-page > app-page > app-post-page-content > app-post-image > div > img");
        Elements video = document.select("body > app-root > app-root-layout-page > div > mat-sidenav-container > mat-sidenav-content > app-post-page > app-page > app-post-page-content > app-post-image > div > div > video > source");
        String src;

        if (!img.isEmpty()) {
            src = img.attr("src").replace("small.jpg", "jpg");
        } else if (!video.isEmpty()) {
            src = video.attr("src").replace("720.mp4", "mp4");
        } else {
            System.out.println("未找到视频或图片！");
            return;
        }

        System.out.println("正在下载 " + src);
        download(src, STR."\{destPath}\{FileUtil.getName(src)}");
    }

    /**
     * 获取书签里的全部 url
     */
    @SneakyThrows
    public static Set<String> getBookmarks() {
        int skip = 0; // 从第几条开始
        int take = 100; // 查询数
        Set<String> ids = new LinkedHashSet<>();

        while (true) {
            String s = reqBookmarks(skip, take);
            Thread.sleep(RandomUtil.randomInt(100, 300));
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
                .timeout(timeout)
                .execute();

        return resp.body();
    }

    /**
     * 下载图片或视频到指定位置
     */
    public static void download(String url, String dest) {
        HttpRequest req = HttpRequest.get(url)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.5410.0 Safari/537.36")
                .timeout(timeout);
        req.setProxy(PROXY);
        FileUtil.writeBytes(req.execute().bodyBytes(), dest);
    }

}
