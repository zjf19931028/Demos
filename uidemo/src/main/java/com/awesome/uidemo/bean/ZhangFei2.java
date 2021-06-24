package com.awesome.uidemo.bean;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.awesome.uidemo.R;
import com.awesome.uidemo.util.BitmapUtil;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/20 17:21
 * Description:张飞2
 */
public class ZhangFei2 extends KlotskiBean {

    public ZhangFei2(Context context) {
        super("张飞", 1, 2, Type.ZHANG_FEI);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),R.mipmap.klotski_zhang_fei);
        Bitmap compressBitmap=BitmapUtil.changeBitmapSize(context,bitmap, 1, 2);
        super.bitmap = Bitmap.createBitmap(compressBitmap, 0, compressBitmap.getHeight() / 2, compressBitmap.getWidth(), compressBitmap.getHeight() / 2);
    }
}
