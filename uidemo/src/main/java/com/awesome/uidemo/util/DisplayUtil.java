package com.awesome.uidemo.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

/**
 * Description:dp,sp,px 相互转换的工具类
 * Author: QinHao
 * Date: 2019/3/6 16:54
 */
public class DisplayUtil {

    /**
     * Description:将 px 转化为 dp
     * Date:2017/9/22
     */
    public static int px2dp(Context context, float pxValue) {
        float density = context.getResources().getDisplayMetrics().density;//得到设备的密度
        return (int) (pxValue / density + 0.5f);
    }

    /**
     * Description:将 dp 转化为 px
     * Date:2017/9/22
     */
    public static int dp2px(Context context, float dpValue) {
        float density = context.getResources().getDisplayMetrics().widthPixels/360;
        return (int) (dpValue * density + 0.5f);
    }

    /**
     * Description:将 px 转化为 sp
     * Date:2017/9/22
     */
    public static int px2sp(Context context, float pxValue) {
        float scaleDensity = context.getResources().getDisplayMetrics().scaledDensity;//缩放密度
        return (int) (pxValue / scaleDensity + 0.5f);
    }

    /**
     * Description:将 sp 转化为 px
     * Date:2017/9/22
     */
    public static int sp2px(Context context, float spValue) {
        float scaleDensity = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * scaleDensity + 0.5f);
    }

    private static final String TAG = "DisplayUtil";

    public static DisplayMetrics getDisplayMetrics(Activity activity){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            //4.2开始有虚拟导航栏，增加了该方法才能准确获取屏幕高度
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        }else{
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            //displayMetrics = activity.getResources().getDisplayMetrics();//或者该方法也行
        }
        return displayMetrics;
    }

    public static DisplayMetrics getDisplayMetrics(Context context){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return displayMetrics;
    }

    /**
     * density ：屏幕密度（像素比例）
     * densityDPI：像素密度（每寸点数）
     * xdpi: 屏幕横向每英寸所占像素数
     * ydpi: 屏幕纵向每英寸所占像素数
     * @param activity
     */
    public static void printDisplayMetrics(Activity activity){
        DisplayMetrics displayMetrics = getDisplayMetrics(activity);
        Log.v(TAG,"---printDisplayMetrics---" +
                "widthPixels=" + displayMetrics.widthPixels
                + ", heightPixels=" + displayMetrics.heightPixels
                + ", density=" + displayMetrics.density
                + ", densityDpi="+displayMetrics.densityDpi);
    }

    public static void printDisplayMetrics(Context context){
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        Log.v(TAG,"---printDisplayMetrics---" +
                "widthPixels=" + displayMetrics.widthPixels
                + ", heightPixels=" + displayMetrics.heightPixels
                + ", density=" + displayMetrics.density
                + ", densityDpi="+displayMetrics.densityDpi);
    }

}