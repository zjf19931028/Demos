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
 * Description:曹操2
 */
public class CaoCao2 extends KlotskiBean {

    public CaoCao2(Context context) {
        super("曹操", 2, 2, Type.CAO_CAO);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.klotski_cao_cao);
        Bitmap compressBitmap=BitmapUtil.changeBitmapSize(context,bitmap,2, 2);
        super.bitmap = Bitmap.createBitmap(compressBitmap, compressBitmap.getWidth() / 2, 0, compressBitmap.getWidth() / 2, compressBitmap.getHeight() / 2);
    }
}
