package com.awesome.demos.test.Service;

import java.io.Serializable;

/**
 * Created by Mjj on 2018/8/11.
 */

public class SerializableImplement implements Serializable {
    /**
     * 生成序列号标识
     */
    private static final long serialVersionUID = -2083503801443301445L;

    private int id;
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
