package com.awesome.imagedemo.util;

import android.text.TextUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Alice on 2021/6/2
 */
public class FileUtil {
    // 创建目录
    public static boolean createDir(File file) {
        File dir = file.getParentFile();
        if (!dir.exists()) {
            if (!dir.mkdirs())
                return false;
        }
        return true;
    }

    // 创建文件
    public static boolean createFile(File file) {
        if (!file.exists()) {
            try {
                if (!file.createNewFile())
                    return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    // 删除文件
    public static boolean delete(File file) {
        if (file == null) return false;
        if (file.exists() && file.delete()) {
            return true;
        }
        return false;
    }

    /**
     * 删除某路径的文件
     *
     * @param path 文件路径
     * @return 删除是否成功
     */
    public static boolean delete(String path) {
        if (TextUtils.isEmpty(path))
            return false;
        File file = new File(path);
        return delete(file);
    }
}