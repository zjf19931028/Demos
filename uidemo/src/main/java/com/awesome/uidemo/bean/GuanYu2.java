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
 * Description:关羽2
 */
public class GuanYu2 extends KlotskiBean {

    public GuanYu2(Context context) {
        super("关羽", 2, 1, Type.GUAN_YU);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.klotski_guan_yu);
        Bitmap compressBitmap= BitmapUtil.changeBitmapSize(context,bitmap, 2, 1);
        super.bitmap = Bitmap.createBitmap(compressBitmap, compressBitmap.getWidth() / 2, 0, compressBitmap.getWidth() / 2, compressBitmap.getHeight());
    }
}
