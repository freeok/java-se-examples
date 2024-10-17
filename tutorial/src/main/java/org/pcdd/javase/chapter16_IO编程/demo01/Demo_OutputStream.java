package org.pcdd.javase.chapter16_IO编程.demo01;

import java.io.*;
import java.util.Scanner;

class FileUtil {

    // 根据路径创建目录
    public static void createDirectory(String dirPath) {
        File file = new File(dirPath);
        if (!file.exists()) {
            file.mkdirs();
            System.out.println("ok");
        }
    }

    // 根据路径创建文件
    public static void createFile(String filePath) {
        File file = new File(filePath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            file.delete();
        } else {
            try {
                file.createNewFile();
                if (file.exists()) {
                    System.out.println("ok");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 写入文件
    public static void fileWrite(String filePath, String content) {
        File file = new File(filePath);
        if (content != null && content.length() > 0) {
            // 判断父路径是否存在，不存在则创建
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            OutputStream os = null;
            try {
                os = new FileOutputStream(file, true);
                os.write(content.getBytes());
                os.close();
                System.out.println("文件" + file.getName() + "写入成功！");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("写入的内容不能为空！");
        }
    }

    // 读取文件,并返回内容
    public static String fileRead(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            InputStream is = null;
            try {
                is = new FileInputStream(file);
                byte[] data = is.readAllBytes();
                return new String(data);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "文件不存在，无法读取！";
    }


}

/**
 * @author pcdd
 */
public class Demo_OutputStream {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("指令：1:创建目录 2:创建文件 3:写入文件 4:读取文件");
            String code = sc.nextLine().replaceAll(" ", "");
            switch (code) {
                case "1":
                    System.out.println("请输入创建目录的路径：");
                    FileUtil.createDirectory(sc.next());
                    break;
                case "2":
                    System.out.println("请输入创建文件的路径：");
                    FileUtil.createFile(sc.next());
                    break;
                case "3":
                    System.out.println("请输入写入文件的路径：");
                    String path = sc.next();
                    System.out.println("请输入写入的内容：");
                    String content = sc.next();
                    FileUtil.fileWrite(path, content);
                    break;
                case "4":
                    System.out.println("请输入读取文件的路径：");
                    System.out.println(FileUtil.fileRead(sc.next()));
                    break;
                case "0":
                    System.out.println("bye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("请输入正确的指令！");
            }
        }
    }
}
