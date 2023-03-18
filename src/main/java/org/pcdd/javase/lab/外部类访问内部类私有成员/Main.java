package org.pcdd.javase.lab.外部类访问内部类私有成员;

import java.io.*;

/**
 * 文件读写时间复杂度比较
 */
class FileTest {
    public final int N = Short.MAX_VALUE;
    public final String filePath = "e:" + File.separator + "pcdd" + File.separator + "info.txt";
    public File file;
    public OutputStream os;
    public InputStream is;
    public BufferedOutputStream bos;
    public BufferedInputStream bis;

    private long start;
    private long end;

    public FileTest() {
        init();
    }

    public void init() {
        file = new File(this.filePath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private long getTime() {
        return System.currentTimeMillis();
    }

    /**
     * OutputStream 写文件
     *
     * @return
     */
    public long write1() {
        try {
            os = new FileOutputStream(file);
            start = getTime();
            // 写入多次
            for (int i = 0; i < Short.MAX_VALUE; i++) {
                os.write(("这是第" + (i + 1) + "行文字\r\n").getBytes());
            }
            end = getTime();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return end - start;
    }

    /**
     * BufferedOutputStream 写文件
     *
     * @return
     */
    public long write2() {
        try {
            bos = new BufferedOutputStream(new FileOutputStream(file));
            start = getTime();
            // 写入多次
            for (int i = 0; i < Short.MAX_VALUE; i++) {
                bos.write(("这是第" + (i + 1) + "行文字\r\n").getBytes());
            }
            end = getTime();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return end - start;
    }

    public long write3() {

        return 0;
    }

    public long read1() {
        try {
            is = new FileInputStream(this.file);
            start = getTime();
            byte[] data = is.readAllBytes();
            System.out.println(new String(data));
            end = getTime();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return end - start;
    }

    public void read2() {

    }

}

/**
 * @author pcdd
 * date 2020/12/23 at G1925
 */
public class Main {
    public static void main(String[] args) throws Exception {
        FileTest obj = new FileTest();
        long l1 = obj.write1();
        long l2 = obj.write2();
        System.out.printf("%dms\n%dms\n%.2f", l1, l2, l1 * 1.0 / l2);

        System.out.println(obj.read1() + "ms");
    }
}
