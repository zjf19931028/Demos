package com.awesome.daggerdemo.Module;


import com.awesome.daggerdemo.Bean.Cola;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alice on 2019/9/19
 *
 * @function
 */

@Module
public class SecondActivityModule {
    @Provides
    Cola offerCola(){
        return new Cola();
    }
}
