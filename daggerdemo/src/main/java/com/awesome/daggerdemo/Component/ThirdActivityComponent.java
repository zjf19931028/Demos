package com.awesome.daggerdemo.Component;

import com.awesome.daggerdemo.Module.ThirdActivityMoudule;
import com.awesome.daggerdemo.ThirdActivity;

import dagger.Component;

/**
 * Created by Alice on 2019/9/19
 *
 * @function
 */
@Component(modules = ThirdActivityMoudule.class)
public interface ThirdActivityComponent {
    void inject(ThirdActivity activity);
}
