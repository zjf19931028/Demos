package com.awesome.recyclerviewdemo.java;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/13 17:33
 * Description:
 */
public class Course {
    private int id;
    private String name;
    private String picSmall;
    private String picBig;
    private String description;
    private int learner;


    public Course(String name) {
        this.name = name;
    }

    public Course(int id, String name, String picSmall, String picBig, String description, int learner) {
        this.id = id;
        this.name = name;
        this.picSmall = picSmall;
        this.picBig = picBig;
        this.description = description;
        this.learner = learner;
    }

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

    public String getPicSmall() {
        return picSmall;
    }

    public void setPicSmall(String picSmall) {
        this.picSmall = picSmall;
    }

    public String getPicBig() {
        return picBig;
    }

    public void setPicBig(String picBig) {
        this.picBig = picBig;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLearner() {
        return learner;
    }

    public void setLearner(int learner) {
        this.learner = learner;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picSmall='" + picSmall + '\'' +
                ", picBig='" + picBig + '\'' +
                ", description='" + description + '\'' +
                ", learner=" + learner +
                '}';
    }
}
