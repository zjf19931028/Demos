package com.awesome.uidemo.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/11/23 20:01
 * Description:软键盘工具类
 */
public class KeyboardUtil {

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date: 2020/11/23 20:01
     * Description:显示软键盘
     */
    public static void showKeyboard(Context context, EditText editText) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(editText, InputMethodManager.RESULT_SHOWN);
            inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        }
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date: 2020/11/23 20:01
     * Description:隐藏软键盘
     */
    public static void hideKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date: 2020/11/23 20:01
     * Description:隐藏软键盘
     */
    public static void hideKeyboard(Context context, EditText editText) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date: 2020/11/23 20:01
     * Description:判断软键盘是否已显示
     */
    public static boolean isKeyboardShown(Activity activity) {
        // 虚拟键盘隐藏 判断 view 是否为空
        View view = activity.getWindow().peekDecorView();
        if (view == null) {
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (inputMethodManager == null) {
            return false;
        }
        return inputMethodManager.isActive() && activity.getWindow().getCurrentFocus() != null;
    }
}
