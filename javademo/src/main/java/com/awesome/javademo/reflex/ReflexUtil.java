package com.awesome.javademo.reflex;


/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/2/25 11:39
 * Description: 反射
 */
public class ReflexUtil {
    public static void getInfo() {
        // 调用Class3种方式
        // 第一种
        // FruitBean.class;
        // 第二种
        // Class.forName("com.future.message.bean.FruitBean");
        // 第三种
        // FruitBean fruitBean = new FruitBean();
        // fruitBean.getClass();
//        FruitBean fruitBean = new FruitBean();
//        try {
//            Method method = fruitBean.getClass().getDeclaredMethod("setColor", String.class);
//            method.invoke(fruitBean,"YELLOW");
//            ShowLogUtil.info(fruitBean.getColor());
//        } catch (Exception e) {
//            ShowLogUtil.info(e.getMessage());
//            e.printStackTrace();
//        }

//        ShowLogUtil.info(" FruitBean.class.getName()=" + FruitBean.class.getName());
//        ShowLogUtil.info(" FruitBean.class.getCanonicalName()=" + FruitBean.class.getCanonicalName());
//        ShowLogUtil.info(" FruitBean.class.getSimpleName()=" + FruitBean.class.getSimpleName());
//        for (int i = 0; i < FruitBean.class.getMethods().length; i++) {
//            ShowLogUtil.info(" FruitBean.class.getMethods() " + i + "=" + FruitBean.class.getMethods()[i].getName());
//        }
    }
}

/**
 *     private void doReflex() {
 *         ReflexUtil.getInfo();
 *     }
 */
