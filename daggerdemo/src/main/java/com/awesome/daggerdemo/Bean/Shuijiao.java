package com.awesome.daggerdemo.Bean;

import javax.inject.Inject;

/**
 * Created by Alice on 2019/9/19
 *
 * @function
 */
public class Shuijiao {
    public String type="羊肉";

    @Inject
    public Shuijiao(String type){
        this.type=type;
    }
}
