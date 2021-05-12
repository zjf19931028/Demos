package com.awesome.javademo.io;

import com.awesome.javademo.activitys.App;
import com.awesome.sdk.util.ShowLogUtil;

import java.io.File;

/**
 * Author: JfangZ
 * Email:zhangjingfang@jeejio.com
 * Date: 2021/2/4 14:51
 * Description: 文件路工具类
 */
public class FilePathUtil {
//    /**
//     * Author: JfangZ
//     * Email:zhangjingfang@jeejio.com
//     * Date: 2021/2/4 14:52
//     * Description: 获取录音的本地文件路径
//     */
//    public static String getMediaRecorderLocalPath() {
//        return App.getInstance().getApplicationContext().getCacheDir()
//                + File.separator
//                + "record"
//                + File.separator
//                + "mediaRecorder"
//                + File.separator
//                + new SimpleDateFormat("yyyyMMdd", Locale.CHINA).format(new Date(System.currentTimeMillis()))
//                + File.separator
//                + System.currentTimeMillis()
//                + ".m4a";
//    }
//
//    /**
//     * Author: JfangZ
//     * Email:zhangjingfang@jeejio.com
//     * Date: 2021/2/4 14:52
//     * Description: 获取录音的本地文件路径
//     */
//    public static String getAudioRecordLocalPath() {
//        return App.getInstance().getApplicationContext().getCacheDir()
//                + File.separator
//                + "record"
//                + File.separator
//                + "audioRecord"
//                + File.separator
//                + new SimpleDateFormat("yyyyMMdd", Locale.CHINA).format(new Date(System.currentTimeMillis()))
//                + File.separator
//                + System.currentTimeMillis()
//                + ".m4a";
//    }
//
//    /**
//     * Author: JfangZ
//     * Email:zhangjingfang@jeejio.com
//     * Date: 2021/2/4 14:52
//     * Description: 获取录音加密的本地文件路径
//     */
//    public static String getMediaRecorderEncryptLocalPath() {
//        return App.getInstance().getApplicationContext().getCacheDir()
//                + File.separator
//                + "record"
//                + File.separator
//                + "mediaRecorder"
//                + File.separator
//                + "encrypt"
//                + File.separator
//                + new SimpleDateFormat("yyyyMMdd", Locale.CHINA).format(new Date(System.currentTimeMillis()))
//                + File.separator
//                + System.currentTimeMillis()
//                + ".m4a";
//    }
//
//    /**
//     * Author: JfangZ
//     * Email:zhangjingfang@jeejio.com
//     * Date: 2021/2/4 14:52
//     * Description: 获取录音加密的本地文件路径
//     */
//    public static String getMediaRecorderDecryptLocalPath() {
//        return App.getInstance().getApplicationContext().getCacheDir()
//                + File.separator
//                + "record"
//                + File.separator
//                + "mediaRecorder"
//                + File.separator
//                + "decrypt"
//                + File.separator
//                + new SimpleDateFormat("yyyyMMdd", Locale.CHINA).format(new Date(System.currentTimeMillis()))
//                + File.separator
//                + System.currentTimeMillis()
//                + ".m4a";
//    }

    /**
     * 获取getCacheDir()路径,/data/user/0/包名/cache
     * @return
     */
    public static String getCacheDirPath() {
        String path = App.getInstance().getApplicationContext().getCacheDir().getAbsolutePath();
        ShowLogUtil.info("cacheDirPath=" + path);
        return path;
    }
}
