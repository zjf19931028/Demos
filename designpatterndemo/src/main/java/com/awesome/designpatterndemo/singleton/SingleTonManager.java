package com.awesome.designpatterndemo.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/18 18:16
 * Description: 管理多种单例的容器
 */
public class SingleTonManager {
    private static Map<String, Object> objMap = new HashMap<>();

    private SingleTonManager() {
    }

    /**
     * 注册单例对象
     * @param key
     * @param instance
     */
    public void registerService(String key, Object instance) {
        if (!objMap.containsKey(key)) {
            objMap.put(key, instance);
        }
    }

    /**
     * 获取单例对象
     * @param key
     * @return
     */
    public Object getService(String key) {
        return objMap.get(key);
    }
}
