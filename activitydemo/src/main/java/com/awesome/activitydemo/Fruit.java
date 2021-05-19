package com.awesome.activitydemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/19 10:28
 * Description:
 */
public class Fruit implements Parcelable {
    String name;
    int color;

    public Fruit(String name, int color) {
        this.name = name;
        this.color = color;
    }

    protected Fruit(Parcel in) {
        name = in.readString();
        color = in.readInt();
    }

    public static final Creator<Fruit> CREATOR = new Creator<Fruit>() {
        @Override
        public Fruit createFromParcel(Parcel in) {
            return new Fruit(in);
        }

        @Override
        public Fruit[] newArray(int size) {
            return new Fruit[size];
        }
    };

    @Override
    public String toString() {
        return "Fruit{" +
                "name=" + name +
                ", color=" + color +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(color);
    }
}
