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
 * Description:曹操3
 */
public class CaoCao3 extends KlotskiBean {

    public CaoCao3(Context context) {
        super("曹操", 2, 2, Type.CAO_CAO);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.klotski_cao_cao);
        // 宽高拉伸到想要的形状
        Bitmap compressBitmap=BitmapUtil.changeBitmapSize(context,bitmap,2, 2);
        super.bitmap = Bitmap.createBitmap(compressBitmap, 0, compressBitmap.getHeight() / 2, compressBitmap.getWidth() / 2, compressBitmap.getHeight() / 2);
    }
}
