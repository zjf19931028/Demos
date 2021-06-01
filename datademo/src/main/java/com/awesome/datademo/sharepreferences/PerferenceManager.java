package com.awesome.datademo.sharepreferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.awesome.datademo.App;

/**
 * Created by Alice on 2021/6/1
 * SharedPreferences管理类
 */
public enum PerferenceManager {
    SINGLETON;
    private static final String NAME = "com.awesome.datademo";
    private final SharedPreferences preferences;

    PerferenceManager() {
        preferences = App.getInstance().getApplicationContext().getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }

    public void putValue(String key,String value){
        preferences.edit().putString(key,value).apply();
    }

    public String getValue(String key){
        return preferences.getString(key,"");
    }

    public void clear(){
        preferences.edit().clear().apply();
    }
}