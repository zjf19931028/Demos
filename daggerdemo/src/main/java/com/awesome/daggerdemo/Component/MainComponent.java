package com.awesome.daggerdemo.Component;


import com.awesome.daggerdemo.MainActivity;

import dagger.Component;

/**
 * Created by Alice on 2019/9/19
 *
 * @function
 */

@Component
public interface MainComponent {
    void inject(MainActivity activity);
}
