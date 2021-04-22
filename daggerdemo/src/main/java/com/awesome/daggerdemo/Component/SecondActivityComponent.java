package com.awesome.daggerdemo.Component;


import com.awesome.daggerdemo.Module.SecondActivityModule;
import com.awesome.daggerdemo.SecondActivity;

import dagger.Component;

/**
 * Created by Alice on 2019/9/19
 *
 * @function
 */
@Component(modules = SecondActivityModule.class)
public interface SecondActivityComponent {
    void inject(SecondActivity activity);
}
