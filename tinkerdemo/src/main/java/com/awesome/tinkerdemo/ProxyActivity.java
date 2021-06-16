package com.awesome.tinkerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ProxyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //拿到要启动的Activity
        String className = getIntent().getStringExtra("className");
        try {
            //加载该Activity的字节码对象
            Class<?> aClass = PluginManager.getInstance().getPluginDexClassLoader().loadClass(className);
            //创建该Activity的示例
            Object newInstance = aClass.newInstance();
            //程序健壮性检查
            if (newInstance instanceof PluginInterface) {
                pluginInterface = (PluginInterface) newInstance;
                //将代理Activity的实例传递给三方Activity
                pluginInterface.attachContext(this);
                //创建bundle用来与三方apk传输数据
                Bundle bundle = new Bundle();
                //调用三方Activity的onCreate，
                pluginInterface.onCreate(bundle);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}