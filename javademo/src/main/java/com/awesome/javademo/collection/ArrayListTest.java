package com.awesome.javademo.collection;

import com.awesome.sdk.util.ShowLogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/21 13:54
 * Description:
 */
public class ArrayListTest {
    public static void getArrayList(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("我是"+i+"个");
        }
        list.remove(5);
        for (int i = 0; i < 10; i++) {
            ShowLogUtil.info("现在下标为"+i+",内容为"+list.get(i));
        }
    }
}
