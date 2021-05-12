package com.awesome.chatpaneldemo.bean;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.ArrayMap;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.awesome.chatpaneldemo.R;
import com.awesome.chatpaneldemo.util.StreamUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/12 11:06
 * Description:
 */
public class Face {
    // 全局的表情的映射ArrayMap，更加轻量级
    private static final ArrayMap<String, Bean> FACE_MAP = new ArrayMap<>();
    private static List<FaceTab> FACE_TABS = null;

    private static void init(Context context) {
        // tip:DCL模式单例， 需要初始化单例对象的情况
        if (FACE_TABS == null) {
            synchronized (Face.class) {
                if (FACE_TABS == null) {
                    ArrayList<FaceTab> faceTabs = new ArrayList<>();
                    FaceTab tab = initAssetsFace(context);

                    if (tab != null) {
                        faceTabs.add(tab);
                    }
                    tab = initResource(context);
                    if (tab != null) {
                        faceTabs.add(tab);
                    }
                    // init map
                    for (FaceTab faceTab : faceTabs) {
                        faceTab.copyToMap(FACE_MAP);
                    }

                    // init list 不可变集合
                    FACE_TABS = Collections.unmodifiableList(faceTabs);
                }
            }
        }
    }

    // 从drawable资源中加载数据并映射到对应的key
    private static FaceTab initResource(Context context) {
        final ArrayList<Bean> faces = new ArrayList<>();
        final Resources resources = context.getResources();

        // tip：使用反射拿到资源
        String packageName = context.getApplicationInfo().packageName;
        for (int i = 1; i < 142; i++) {
            // i=1 => 001 tip:用三位，不够的用0占位
            String key = String.format(Locale.ENGLISH, "fb%03d", i);
            String resStr = String.format(Locale.ENGLISH, "face_base_%03d", i);

            // 根据资源名称去拿资源对应的ID
            int resId = resources.getIdentifier(resStr, "drawable", packageName);

            if (resId == 0) continue;
            // 添加表情
            faces.add(new Bean(key, resId));
        }
        if (faces.size() == 0) return null;
        return new FaceTab("NAME", faces.get(0).preview, faces);
    }


    // tip:处理解压文件
    // 从face-t.zip包解析我们的表情
    private static FaceTab initAssetsFace(Context context) {
        String faceAsset = "face-t.zip";
        // data/data/包名/files/face/ft/*
        String faceCacheDir = String.format("%s/face/tf", context.getFilesDir());
        File faceFolder = new File(faceCacheDir);
        if (!faceFolder.exists()) {
            // 不存在进行初始化
            if (faceFolder.mkdirs()) {
                try {
                    InputStream inputStream = context.getAssets().open(faceAsset);
                    // 存储文件
                    File faceSource = new File(faceFolder, "source.zip");
                    // copy
                    StreamUtil.copy(inputStream, faceSource);

                    // 解压
                    unZipFile(faceSource, faceFolder);

                    // 清理文件
                    StreamUtil.delete(faceSource.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        // info.json
        File infoFile = new File(faceCacheDir, "info.json");
        // Gson

        Gson gson = new Gson();
        JsonReader reader;
        try {
            reader = gson.newJsonReader(new FileReader(infoFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        // 解析
        FaceTab tab = gson.fromJson(reader, FaceTab.class);

        // 相对路径到绝对路径
        for (Bean face : tab.faces) {
            face.preview = String.format("%s/%s", faceCacheDir, face.preview);
            face.source = String.format("%s/%s", faceCacheDir, face.source);
        }

        return tab;


//        String faceAsset = "face-t.zip";
//        // /data/data/包名/files/face/ft/*
//        String faceCacheDir = String.format("%s/face/tf", context.getFilesDir());
//        File faceFolder = new File(faceCacheDir);
//        ShowLogUtil.info("(!faceFolder.exists())=" + (!faceFolder.exists()));
//        if (!faceFolder.exists()) {
//            // 不存在进行初始化
//            if (faceFolder.mkdirs()) {
//                try {
//                    // 输入流
//                    InputStream inputStream = context.getAssets().open(faceAsset);
//                    // 存储文件
//                    File faceSource = new File(faceFolder, "source.zip");
//                    //copy
//                    StreamUtil.copy(inputStream, faceSource);
//
//                    // 解压
//                    unZipFile(faceSource, faceFolder);
//
//                    //清理文件
//                    StreamUtil.delete(faceSource.getAbsolutePath());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        ShowLogUtil.info("info.json");
//        // info.json
//        File infoFile = new File(faceCacheDir, "info.json");
//        // Gson
//        Gson gson = new Gson();
//        JsonReader reader;
//        try {
//            reader = gson.newJsonReader(new FileReader(infoFile));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        }
//        // 解析
//        FaceTab tab = gson.fromJson(reader, FaceTab.class);
//        ShowLogUtil.info("tab");
//        // 相对路径到绝对路径
//        for (Bean face : tab.faces) {
//            face.preview = String.format("%s/%s", faceCacheDir, face.preview);
//            face.source = String.format("%s/%s", faceCacheDir, face.source);
//        }
//        return tab;
    }

    private static void unZipFile(File zipFile, File desDir) throws IOException {
        final String folderPath = desDir.getAbsolutePath();

        ZipFile zf = new ZipFile(zipFile);
        // 判断节点进行循环
        for (Enumeration<?> entries = zf.entries(); entries.hasMoreElements(); ) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            // 过滤缓存的文件
            String name = entry.getName();
            if (name.startsWith("."))
                continue;

            // 输入流
            InputStream in = zf.getInputStream(entry);
            String str = folderPath + File.separator + name;

            // 防止名字错乱
            str = new String(str.getBytes("8859_1"), "GB2312");

            File desFile = new File(str);
            // 输出文件
            StreamUtil.copy(in, desFile);
        }
//        final String folderPath = desDir.getAbsolutePath();
//
//        ZipFile zf = new ZipFile(zipFile);
//        // 判断节点进行循环
//        for (Enumeration<?> entries = zf.entries(); entries.hasMoreElements(); ) {
//            ZipEntry entry = (ZipEntry) entries.nextElement();
//            // 过滤缓存的文件
//            String name = entry.getName();
//            if (name.startsWith("."))
//                continue;
//
//            // 输入流
//            InputStream in = zf.getInputStream(entry);
//            String str = folderPath + File.separator + name;
//
//            // 防止名字错乱
//            str = new String(str.getBytes("8859_1"), "GB2312");
//
//            File desFile = new File(str);
//            // 输出文件
//            StreamUtil.copy(in, desFile);
//        }
    }


    /**
     * 获取所有的表情
     */
    public static List<FaceTab> all(@NonNull Context context) {
        init(context);
        return FACE_TABS;
    }

    /**
     * 输入一个表情到editable
     */
    public static void inputFace(@NonNull Context context, Editable editable,
                                 Bean bean, int size) {
        Glide.with(context)
                .load(bean.preview)
                .into(new SimpleTarget<Drawable>(size, size) {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        // tip：Editable和Spannable
                        Spannable spannable = new SpannableString(String.format("[%s]", bean.key));
                        ImageSpan span = new ImageSpan(context, (int) bean.preview, ImageSpan.ALIGN_BASELINE);
                        spannable.setSpan(span, 0, spannable.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        editable.append(spannable);
                    }
                });
    }

    // 拿一个Bean
    // key:ft001
    public static Bean get(Context context, String key) {
        init(context);
        if (FACE_MAP.containsKey(key)) {
            return FACE_MAP.get(key);
        }
        return null;
    }

    /**
     * 从Spannable解析表情并替换显示
     */
    public static Spannable decode(View target, Spannable spannable, int size) {
        if (spannable == null) return null;
        String str = spannable.toString();
        if (TextUtils.isEmpty(str)) return null;
        final Context context = target.getContext();
        // 进行正在匹配[][][]
        // tip:正则匹配
        Pattern pattern = Pattern.compile("(\\[[^\\[\\]:\\s\\n]+\\])");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String key = matcher.group();
            if (TextUtils.isEmpty(key)) continue;
            Bean bean = get(context, key.replace("[", "").replace("]", ""));
            if (bean == null) continue;
            final int start = matcher.start();
            final int end = matcher.end();
            //
            ImageSpan span = new FaceSpan(context, target, bean.preview, size);
            spannable.setSpan(span, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return spannable;
    }

    // 表情标示
    public static class FaceSpan extends ImageSpan {

        private Drawable mDrawable;
        private View mView;
        private int mSize;

        /**
         * @param context
         * @param view    目标View
         * @param source  加载目标
         * @param size    图片大小
         */
        public FaceSpan(@NonNull Context context, View view, Object source, int size) {
            // 默认图片仅占位
            super(context, R.drawable.default_face, ALIGN_BASELINE);
            mView = view;
            Glide.with(context)
                    .load(source)
                    .fitCenter()
                    .into(new SimpleTarget<Drawable>(size, size) {
                        @Override
                        public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                            mDrawable = resource.getCurrent();
                            int width = mDrawable.getIntrinsicWidth();
                            int height = mDrawable.getIntrinsicHeight();

                            mDrawable.setBounds(0, 0, width > 0 ? width : size,
                                    height > 0 ? height : size);
                            // 通知刷新
                            mView.invalidate();
                        }
                    });
        }

        @Override
        public Drawable getDrawable() {
            return mDrawable;
        }

        @Override
        public int getSize(@NonNull Paint paint, CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm) {
            Rect rect = mDrawable != null ? mDrawable.getBounds() : new Rect(0, 0, mSize, mSize);
            if (fm != null) {
                fm.ascent = -rect.bottom;
                fm.descent = 0;
                fm.top = fm.ascent;
                fm.bottom = 0;
            }
            return rect.right;
        }

        @Override
        public void draw(@NonNull Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, @NonNull Paint paint) {
            if (mDrawable != null)
                super.draw(canvas, text, start, end, x, top, y, bottom, paint);
        }
    }

    /**
     * 每一个表情盘，有很多表情
     */
    public static class FaceTab {
        public List<Bean> faces = new ArrayList<>();
        public String name;
        public Object preview;

        public FaceTab(String name, Object preview, List<Bean> faces) {
            this.faces = faces;
            this.name = name;
            this.preview = preview;
        }

        public void copyToMap(ArrayMap<String, Bean> faceMap) {
            for (Bean face : faces) {
                faceMap.put(face.key, face);
            }
        }
    }

    /**
     * 每一个表情
     */
    public static class Bean {
        public Bean(String key, Object preview) {
            this.key = key;
            this.source = preview;
            this.preview = preview;
        }

        public String key;
        public String desc;
        public Object source;
        public Object preview;

    }
}
