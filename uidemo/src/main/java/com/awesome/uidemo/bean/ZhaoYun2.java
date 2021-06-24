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
 * Description:赵云2
 */
public class ZhaoYun2 extends KlotskiBean {

    public ZhaoYun2(Context context) {
        super("赵云", 1, 2, Type.ZHAO_YUN);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.klotski_zhao_yun);
        Bitmap compressBitmap=BitmapUtil.changeBitmapSize(context,bitmap, 1, 2);
        super.bitmap = Bitmap.createBitmap(compressBitmap, 0, compressBitmap.getHeight() / 2, compressBitmap.getWidth(), compressBitmap.getHeight() / 2);
    }
}
