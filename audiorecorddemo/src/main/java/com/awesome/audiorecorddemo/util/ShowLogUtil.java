package com.awesome.audiorecorddemo.util;

import android.content.pm.ApplicationInfo;
import android.util.Log;

import com.awesome.audiorecorddemo.App;

/**
 * Author: JfangZ
 * Email:zhangjingfang@jeejio.com
 * Date: 2021/2/22 15:42
 * Description:
 */
public class ShowLogUtil {
    private static final String TAG = "jlog";
    private static final int LENGTH = 1024;
    private static final String DEVIDER = "--------------------";

    public ShowLogUtil() {
    }

    private static boolean isDebug() {
        try {
            ApplicationInfo info = App.getInstance().getApplicationInfo();
            return (info.flags & 2) != 0;
        } catch (Exception var1) {
            return false;
        }
    }

    public static void info(Object log) {
        info(log.toString());
    }

    public static void info(String log) {
        info("jlog", log);
    }

    public static void info(String tag, String log) {
        if (isDebug()) {
            int a = log.length() / 1024;
            int b = log.length() % 1024;

            for(int i = 0; i < a; ++i) {
                Log.i(tag, log.substring(i * 1024, (i + 1) * 1024));
            }

            Log.i(tag, log.substring(a * 1024, a * 1024 + b));
        }
    }

    public static void debug(Object log) {
        debug(log.toString());
    }

    public static void debug(String log) {
        debug("jlog", log);
    }

    public static void debug(String tag, String log) {
        if (isDebug()) {
            int a = log.length() / 1024;
            int b = log.length() % 1024;

            for(int i = 0; i < a; ++i) {
                Log.d(tag, log.substring(i * 1024, (i + 1) * 1024));
            }

            Log.d(tag, log.substring(a * 1024, a * 1024 + b));
        }
    }

    public static void error(Object log) {
        error(log.toString());
    }

    public static void error(String log) {
        error("jlog", log);
    }

    public static void error(String tag, String log) {
        if (isDebug()) {
            int a = log.length() / 1024;
            int b = log.length() % 1024;

            for(int i = 0; i < a; ++i) {
                Log.e(tag, log.substring(i * 1024, (i + 1) * 1024));
            }

            Log.e(tag, log.substring(a * 1024, a * 1024 + b));
        }
    }
}
