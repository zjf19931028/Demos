package com.awesome.imagedemo.util;

import android.graphics.BitmapFactory;
import android.util.Log;

import com.awesome.sdk.base.BaseApplication;
import com.awesome.sdk.util.ShowLogUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.io.File;


/**
 *
 */
@SuppressWarnings("WeakerAccess")
public final class PicturesCompressor {

    public static boolean compressImage(final String srcPath,
                                        final String savePath,
                                        final long targetSize) {
        return compressImage(srcPath, savePath, targetSize, 80, 1448, 1448, null, null, true);
    }


    /**
     * 压缩图片
     *
     * @param srcPath     原图地址
     * @param savePath    存储地址
     * @param maxSize     最大文件地址byte
     * @param minQuality  最小质量
     * @param maxWidth    最大宽度
     * @param maxHeight   最大高度
     * @param byteStorage 用于批量压缩时的buffer，不必要为null，
     *                    需要时，推荐 {{@link BitmapUtil#DEFAULT_BUFFER_SIZE}}
     * @param options     批量压缩时复用参数，可调用 {{@link BitmapUtil#createOptions()}} 得到
     * @param exactDecode 是否精确解码， TRUE： 在4.4及其以上机器中能更节约内存
     * @return 是否压缩成功
     */
    public static boolean compressImage(final String srcPath,
                                        final String savePath,
                                        final long maxSize,
                                        final int minQuality,
                                        final int maxWidth,
                                        final int maxHeight,
                                        byte[] byteStorage,
                                        BitmapFactory.Options options,
                                        boolean exactDecode) {
        // 创建源文件
        File inTmp = new File(srcPath);
        ShowLogUtil.info("源文件大小="+inTmp.length());
        final File sourceFile;
        // 本地文件
        if (inTmp.exists()) {
            sourceFile = inTmp;
        } else {
            File tmp = loadWithGlideCache(srcPath);
            if (tmp == null)
                return false;
            sourceFile = tmp;
        }

        final File saveFile = new File(savePath);
        if (!FileUtil.createDir(saveFile) && !FileUtil.delete(saveFile))
            return false;

        // 如果文件大小小于等于maxSize, 我们可以复制到保存文件
        if (sourceFile.length() <= maxSize && BitmapUtil.confirmImage(sourceFile, options)) {
            return StreamUtil.copy(sourceFile, saveFile);
        }
        // 压缩图片
        File tempFile = BitmapUtil.Compressor.compressImage(sourceFile, maxSize, minQuality, maxWidth,
                maxHeight, byteStorage, options, exactDecode);

        // 复制到保存的地址
        return tempFile != null && StreamUtil.copy(tempFile, saveFile) && tempFile.delete();
    }


    /**
     * 使用Glide加载缓存
     * @param path
     * @return
     */
    public static File loadWithGlideCache(String path) {
        File tmp;
        try {
            tmp = Glide.with(BaseApplication.getInstance())
                    .load(path)
                    .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .get();
            String absPath = tmp.getAbsolutePath();
            Log.d("PicturesCompressor", "loadWithGlideCache:" + absPath);
            return tmp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
