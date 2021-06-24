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
 * Description:黄忠2
 */
public class HuangZhong2 extends KlotskiBean {

    public HuangZhong2(Context context) {
        super("黄忠", 1, 2, Type.HUANG_ZHONG);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),  R.mipmap.klotski_huang_zhong);
        Bitmap compressBitmap=BitmapUtil.changeBitmapSize(context,bitmap, 1, 2);
        super.bitmap = Bitmap.createBitmap(compressBitmap, 0, compressBitmap.getHeight() / 2,  compressBitmap.getWidth(), compressBitmap.getHeight() / 2);
    }
}
