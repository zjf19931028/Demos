package com.awesome.uidemo.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;


/**
 * created by zhangjingfang on 2020/6/18
 * Description:压缩成适合的比例
 */
public class BitmapUtil {
    public static Bitmap changeBitmapSize(Context context, Bitmap bitmap, int widthMultiple, int heightMultiple) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        //设置想要的大小
        int newWidth = (context.getResources().getDisplayMetrics().widthPixels - DisplayUtil.dp2px(context, 42)) / 4 * widthMultiple ;
        int newHeight = (context.getResources().getDisplayMetrics().widthPixels - DisplayUtil.dp2px(context, 42)) / 4 * heightMultiple ;
        //计算压缩的比率
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        //获取想要缩放的matrix
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        //获取新的bitmap
        bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        return bitmap;
    }
}
