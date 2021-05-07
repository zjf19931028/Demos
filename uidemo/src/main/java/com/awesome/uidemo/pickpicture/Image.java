package com.awesome.uidemo.pickpicture;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/7 17:05
 * Description:
 */
public class Image {
    public int id; // 数据的ID
    public String path; // 图片的路径
    public long date; // 图片的创建日期
    public boolean isSelect; // 是否选中

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        return path != null ? path.equals(image.path) : image.path == null;
    }

    @Override
    public int hashCode() {
        return path != null ? path.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", date=" + date +
                ", isSelect=" + isSelect +
                '}';
    }
}
