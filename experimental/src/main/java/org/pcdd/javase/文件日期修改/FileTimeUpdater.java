package org.pcdd.javase.文件日期修改;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class FileTimeUpdater {

    public static void main(String[] args) {
        // 文件路径
        Path filePath = Paths.get("e:\\1.txt");

        // 创建时间和修改时间
        LocalDateTime newDateTime = LocalDateTime.of(2018, 1, 1, 0, 0);
        FileTime newTime = FileTime.from(newDateTime.atZone(ZoneId.systemDefault()).toInstant());

        try {
            // 修改文件的最后修改时间
            Files.setLastModifiedTime(filePath, newTime);
            System.out.println("修改时间已更新");

            // 修改文件的创建时间（仅适用于支持此属性的文件系统）
            BasicFileAttributeView attributes = Files.getFileAttributeView(filePath, BasicFileAttributeView.class);
            if (attributes != null) {
                attributes.setTimes(null, null, newTime); // 第三个参数是创建时间
                System.out.println("创建时间已更新");
            } else {
                System.out.println("无法修改创建时间，该文件系统可能不支持。");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
