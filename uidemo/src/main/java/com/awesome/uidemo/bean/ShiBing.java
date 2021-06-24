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
 * Description:士兵
 */
public class ShiBing extends KlotskiBean {

    public ShiBing(Context context) {
        super("士兵", 1, 1, Type.SHI_BING);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.klotski_shi_bing);
        Bitmap compressBitmap= BitmapUtil.changeBitmapSize(context,bitmap, 1, 1);
        super.bitmap = Bitmap.createBitmap(compressBitmap, 0, 0, compressBitmap.getWidth() , compressBitmap.getHeight());
    }
}
