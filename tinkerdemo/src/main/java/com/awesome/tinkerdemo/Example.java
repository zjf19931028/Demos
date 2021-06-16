package com.awesome.tinkerdemo;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;
/**
 * Created by Alice on 2021/6/10
 */
public class Example {
    String mDexPath = "";

    public void test(Activity context){
        String dexOutputDirPath = context.getDir("dex", Context.MODE_PRIVATE).getAbsolutePath();
        DexClassLoader dexClassLoader = new DexClassLoader(mDexPath,
                dexOutputDirPath, null, context.getClassLoader());
        try {
            // 使用DexClassLoader加载类
            Class<?> loadClass = dexClassLoader.loadClass("className");
            // 调用类的构造
            Constructor<?> loadConstructor = loadClass.getConstructor(new Class[]{});
            // 获取类对象
            Object instace = loadConstructor.newInstance(new Object[]{});
            // 获取本类或父类方法
            Method setProxy = loadClass.getMethod("setProxy",
                    new Class[]{Activity.class});
            // 禁止JVM安全检查，加快反射速度
            setProxy.setAccessible(true);
            // 调用方法
            setProxy.invoke(instace, new Object[]{this});
            // 获取本类的方法
            Method onCreate = loadClass.getDeclaredMethod("onCreate", new Class[]{Bundle.class});
            onCreate.setAccessible(true);
            Bundle bundle = new Bundle();
            bundle.putInt("FROM", 1);
            // 调用有参数的方法
            onCreate.invoke(instace, new Object[]{bundle});

        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        AssetManager mAssetManager = null;

        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            Method addAssetPath = assetManager.getClass().getMethod("addAssetPath", String.class);
            addAssetPath.invoke(assetManager, mDexPath);
            mAssetManager = assetManager;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Resources superRes = context.getResources();
        Resources resources = new Resources(mAssetManager, superRes.getDisplayMetrics(),
                superRes.getConfiguration());
        Resources.Theme theme = resources.newTheme();
        theme.setTo(context.getTheme());


        String[] methodNames = new String[]{"onRestart", "onStart", "onResume", "onPause",
                "onStop", "onDestory"};
        for (String methodName : methodNames) {
            try {
                Class<?> loadClass = dexClassLoader.loadClass("className");
                Method method = loadClass.getDeclaredMethod(methodName, new Class[]{});
                method.setAccessible(true);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
} 