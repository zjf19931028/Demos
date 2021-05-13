package com.awesome.audiorecorddemo.util.io;

import com.awesome.sdk.util.ShowLogUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Author: JfangZ
 * Email:zhangjingfang@jeejio.com
 * Date: 2021/2/23 09:09
 * Description: File工具类
 */
public class FileUtil {
    /**
     * Author: JfangZ
     * Email:zhangjingfang@jeejio.com
     * Date: 2021/2/23 09:11
     * Description: 创建文件
     */
    public static File createFile() {
        // /data/user/0/com.future.message/cache/zjf5586373986259348895.txt
        File tempFile = null;
        try {
            tempFile = File.createTempFile("temp", ".txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempFile;
        // /data/user/0/com.future.message/cache/zjf/20210302/1614669744032.txt
//        File file = new File(App.getInstance().getApplicationContext().getCacheDir()
//                + File.separator + "zjf"
//                + File.separator + new SimpleDateFormat("yyyyMMdd", Locale.CHINA).format(new Date(System.currentTimeMillis()))
//                + File.separator + System.currentTimeMillis() + ".txt");
//        if (!file.exists()) {
//            try {
//                file.getParentFile().mkdirs();
//                file.createNewFile();
//                return file;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
    }

    public static void delete(File deleteFile) {
        if (deleteFile != null)
            deleteFile.delete();
    }

    /**
     * 字节流的读
     *
     * @param file
     */
    public static void byteRead(File file) {
        try {
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[inputStream.available()];
            int n = inputStream.read(bytes);
//            ShowLogUtil.info(new String(bytes, 0, n));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节流的写入
     */
    public static void byteWrite(File file) {
        try {
            OutputStream outputStream = new FileOutputStream(file);
            String text = "Hello World";
            byte[] data = text.getBytes();
            outputStream.write(data);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节流的读
     *
     * @param file
     */
    public static void byteReadToWrite(File file,File newFile) {
        try {
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[inputStream.available()];
            OutputStream outputStream = new FileOutputStream(newFile);
            inputStream.read(bytes);
            outputStream.write(bytes);
            inputStream.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void stringRead(File file) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            String str = reader.readLine();
            ShowLogUtil.info(str);
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void stringWrite(File file) {
        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"GB2312"));
            String text = "Hello World 你好世界";
            writer.write(text);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void stringReadToWrite(File file, File newFile) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GB2312"));
            String str = reader.readLine();
            ShowLogUtil.info(str);
            Writer writer = new FileWriter(newFile);
            writer.write(str);
            writer.write("stringReadToWrite");
            writer.flush();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
