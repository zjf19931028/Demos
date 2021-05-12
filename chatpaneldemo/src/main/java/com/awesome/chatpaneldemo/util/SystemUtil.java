package com.awesome.chatpaneldemo.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import android.view.WindowManager;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;

/**
 * Description:获取手机系统信息的工具类
 * Created by 禽兽先生
 * Created on 2017/9/1
 */

public class SystemUtil {

    /**
     * Description:获取系统语言
     * Date:2017/9/1
     */
    public static String getLanguage(Context context) {
        String language = "";
        Locale mLocale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mLocale = context.getResources().getConfiguration().getLocales().get(0);
        } else {
            mLocale = context.getResources().getConfiguration().locale;
        }
        language = mLocale.getLanguage() + "-" + mLocale.getCountry();
        return language;
    }

    /**
     * Description:获取屏幕宽度,不包括虚拟按键的宽度
     * Date:2017/9/1
     */
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * Description:获取屏幕高度,不包括虚拟按键的高度
     * Date:2017/9/1
     */
    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * Description:获取屏幕真实宽度,包括虚拟按键的高度
     * Date:2017/9/1
     */
    public static int getRealScreenWidth(Context context) {
        int realWidth = 0;
        WindowManager mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display mDisplay = mWindowManager.getDefaultDisplay();
        DisplayMetrics mDisplayMetrics = new DisplayMetrics();
        Class clazz;
        try {
            clazz = Class.forName("android.view.Display");
            @SuppressWarnings("unchecked")
            Method method = clazz.getMethod("getRealMetrics", DisplayMetrics.class);
            method.invoke(mDisplay, mDisplayMetrics);
            realWidth = mDisplayMetrics.widthPixels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return realWidth;
    }

    /**
     * Description:获取屏幕真实高度,包括虚拟按键的高度
     * Date:2017/9/1
     */
    public static int getRealScreenHeight(Context context) {
        int realHeight = 0;
        WindowManager mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display mDisplay = mWindowManager.getDefaultDisplay();
        DisplayMetrics mDisplayMetrics = new DisplayMetrics();
        Class clazz;
        try {
            clazz = Class.forName("android.view.Display");
            @SuppressWarnings("unchecked")
            Method method = clazz.getMethod("getRealMetrics", DisplayMetrics.class);
            method.invoke(mDisplay, mDisplayMetrics);
            realHeight = mDisplayMetrics.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return realHeight;
    }

    /**
     * Description:获取状态栏高度,返回像素
     * Date:2017/9/1
     */
    public static int getStatusBarHeight(Context context) {
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return resourceId > 0 ? context.getResources().getDimensionPixelSize(resourceId) : 0;
    }


    /**
     * Description:获取应用程序名称
     * Date:2018/7/13
     */
    public static synchronized String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return context.getResources().getString(labelRes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Description:获取手机型号
     * Date:2017/9/11
     */
    public static String getModel() {
        return Build.MODEL;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/2/26 9:01
     * Description:获取设备 Id,获取的值为设备首次启动时系统随机生成的一个 64 位的数字,在重新 root 后
     * 可能会变,但该方式不需要额外权限,且大部分情况下能保证唯一,所以暂时使用该方式
     */
    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    /**
     * 将得到的int类型的 IP 转换为String类型
     */
    private static String intIp2String(int ip) {
        return (ip & 0xFF) + "." +
                ((ip >> 8) & 0xFF) + "." +
                ((ip >> 16) & 0xFF) + "." +
                (ip >> 24 & 0xFF);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/8/13 9:29
     * Description:判断应用是否在后台
     *
     * @param context 上下文
     * @return true 表示在后台,false 表示在前台
     */
    public static boolean isBackground(Context context) throws Exception {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager == null) {
            throw new Exception("ActivityManager is null");
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcessInfoList = activityManager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcessInfoList) {
            if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                return runningAppProcessInfo.importance != ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND;
            }
        }
        throw new Exception("Your app is running?");
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/7/17 17:50
     * Description:获取异形屏的异形高度
     */
    public static int getSafeInsetTop(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return 0;
        }
        WindowInsets windowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
        if (windowInsets == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
            return 0;
        }
        DisplayCutout displayCutout = windowInsets.getDisplayCutout();
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.getSafeInsetTop();
    }
}