package com.awesome.arouterdemo;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.awesome.sdk.util.ShowLogUtil;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/16 17:13
 * Description:
 */
@Interceptor(priority = 7)
public class UserSecondInterceptor implements IInterceptor {
    // 拦截处理方法
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        ShowLogUtil.info("UserSecondInterceptor 拦截器开始执行：线程名称="+Thread.currentThread().getName());
        // 特殊页面处理
        if (TextUtils.equals(postcard.getPath(),Constance.ACTIVITY_URL_SECOND))
            ShowLogUtil.info(UserSecondInterceptor.class.getName()+"进行了拦截处理");
        // 不拦截，继续执行
        callback.onContinue(postcard);
    }

    // 拦截初始化
    @Override
    public void init(Context context) {
        ShowLogUtil.info("UserSecondInterceptor init");

    }
}

