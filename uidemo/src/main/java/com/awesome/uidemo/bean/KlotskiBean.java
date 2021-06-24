package com.awesome.uidemo.bean;

import android.graphics.Bitmap;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/19 16:24
 * Description:华容道实体类
 */
public class KlotskiBean {
    /**
     * 华容道方块对应的图片
     */
    Bitmap bitmap;
    /**
     * 华容道方块对应的文字
     */
    private String text;
    private int color;
    private int width;
    private int height;
    private Type type;

    public KlotskiBean(String text, int width, int height, Type type) {
        this.text = text;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    @Override
    public String toString() {
        return "KlotskiBean{" +
                "text='" + text + '\'' +
                ", color=" + color +
                ", width=" + width +
                ", height=" + height +
                ", type=" + type +
                '}';
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        CAO_CAO,
        GUAN_YU,
        ZHANG_FEI,
        ZHAO_YUN,
        HUANG_ZHONG,
        MA_CHAO,
        SHI_BING,
        NULL,
    }
}
