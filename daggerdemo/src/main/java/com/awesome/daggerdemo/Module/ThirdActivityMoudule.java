package com.awesome.daggerdemo.Module;

import com.awesome.daggerdemo.Bean.CokeCola;
import com.awesome.daggerdemo.Bean.Shuijiao;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alice on 2019/9/19
 *
 * @function
 */

@Module
public class ThirdActivityMoudule {
    String brand;
    String type;
    public ThirdActivityMoudule(String brand, String type){
        this.brand=brand;
        this.type=type;
    }

    @Provides
    public CokeCola offerCola(){
        return new CokeCola(brand);
    }

    @Provides
    public Shuijiao offerShuijiao(){
        return new Shuijiao(type);
    }
}
