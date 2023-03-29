package org.pcdd.javase.experimental.纯色图片生成;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author pcdd
 * create at 2023/03/30 00:14
 */
public class Main {
    public static void main(String[] args) {
        pureColorPictures(1000, 1000, Color.BLACK);
    }

    public static void pureColorPictures(int width, int height, Color color) {
        // width 生成图宽度
        // height 生成图高度
        // 创建一个width x height像素RGB高彩图，类型可自定
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 取得图形
        Graphics g = img.getGraphics();
        // 设置颜色
        g.setColor(color);
        // 填充
        g.fillRect(0, 0, img.getWidth(), img.getHeight());
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/pureColor.jpg");
        try {
            ImageIO.write(img, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
