package com.awesome.jetpackdemo.component.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Author: zhangjingfang
 * Email:zhangjingfang@jeejio.com
 * Date: 2021/6/21 2:13 上午
 * Description:类描述
 */
public class SimpleViewModel extends ViewModel {
    private MutableLiveData<String> content;

    public MutableLiveData<String> getContent() {
        if (content == null) {
            content = new MutableLiveData<>();
        }
        return content;
    }

    public void setContent(MutableLiveData<String> content) {
        this.content = content;
    }


    /**
     * 获取数据
     */
    public void getContentData() {
        //这里可以加一层Repository从网络/缓存加载数据
        //执行完毕后调用 setValue/postValue方法,最终会回调Activity中的onChange方法

        content.setValue("我是获取到的数据");
        //子线程调用  content.postValue(""我是获取到的数据");
    }
} 