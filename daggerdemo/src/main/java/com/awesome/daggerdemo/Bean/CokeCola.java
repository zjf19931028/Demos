package com.awesome.daggerdemo.Bean;

import javax.inject.Inject;

/**
 * Created by Alice on 2019/9/19
 *
 * @function
 */
public class CokeCola {
    public String brand="";

    @Inject
    public CokeCola(String brand){
        this.brand=brand;
    }
}
