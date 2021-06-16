package com.awesome.demos.test.Service;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mjj on 2018/8/11.
 */

public class ParcableImplement implements Parcelable {

    public int id;
    public String name;


    /**
     * 当前对象的内容描述,一般返回0即可
     *
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    protected ParcableImplement(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
    }

    /**
     * 将当前对象写入序列化结构中
     *
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
    }

    /**
     * public static final一个都不能少，内部对象CREATOR的名称也不能改变，必须全部大写。
     * 重写接口中的两个方法：
     * createFromParcel(Parcel in) 实现从Parcel容器中读取传递数据值,封装成Parcelable对象返回逻辑层，
     * newArray(int size) 创建一个类型为T，长度为size的数组，供外部类反序列化本类数组使用。
     */
    public static final Creator<ParcableImplement> CREATOR = new Creator<ParcableImplement>() {
        /**
         * 从序列化后的对象中创建原始对象
         */
        @Override
        public ParcableImplement createFromParcel(Parcel in) {
            return new ParcableImplement(in);
        }

        /**
         * 创建指定长度的原始对象数组
         * @param size
         * @return
         */
        @Override
        public ParcableImplement[] newArray(int size) {
            return new ParcableImplement[size];
        }
    };


}
