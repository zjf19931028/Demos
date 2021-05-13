//package com.awesome.chatpaneldemo.jeejio.kotlin
//
//import android.content.Context
//import android.graphics.Canvas
//import android.graphics.Paint
//import android.graphics.Rect
//import android.graphics.drawable.Drawable
//import android.text.*
//import android.text.style.ImageSpan
//import android.util.ArrayMap
//import android.view.View
//import com.bumptech.glide.Glide
//import com.bumptech.glide.request.target.SimpleTarget
//import com.bumptech.glide.request.transition.Transition
//import com.jeejio.wutong.R
//
//import java.util.*
//import java.util.regex.Pattern
//
//
///**
// * Author: JfangZ
// * Email: zhangjingfang@jeejio.com
// * Date: 2021/5/13 16:18
// * Description:
// */
//class Face {
//    companion object {
//
//        // 全局的表情的映射ArrayMap，更加轻量级
//        private val FACE_MAP = ArrayMap<String, Bean>()
//        private var FACE_TABS: List<FaceTab?>? = null
//
//        private fun init(context: Context) {
//            // tip:DCL模式单例， 需要初始化单例对象的情况
//            if (FACE_TABS == null) {
//                synchronized(Face::class.java) {
//                    if (FACE_TABS == null) {
//                        val faceTabs = ArrayList<FaceTab>()
//                        val tab = initEmoji(context)
//                        if (tab != null) {
//                            faceTabs.add(tab)
//                        }
//                        val tab2 = initSExpression(context)
//                        if (tab2 != null) {
//                            faceTabs.add(tab2)
//                        }
//                        //                    tab = initAssetsFace(context);
////                    if (tab != null) {
////                        faceTabs.add(tab);
////                    }
//                        // init map
//                        for (faceTab in faceTabs) {
//                            faceTab.copyToMap(FACE_MAP)
//                        }
//
//                        // init list 不可变集合
//                        FACE_TABS = Collections.unmodifiableList(faceTabs)
//                    }
//                }
//            }
//        }
//
//        // 从drawable资源中加载数据并映射到对应的key
//        private fun initEmoji(context: Context): FaceTab? {
//            val faces = ArrayList<Bean>()
//            val resources = context.resources
//
//            // tip：使用反射拿到资源
//            val packageName = context.applicationInfo.packageName
//            var i = 0
//            while (i++ < 100) {
//                // i=1 => 001 tip:用三位，不够的用0占位
//                val key = String.format(Locale.ENGLISH, "fb%03d", i)
//                // 根据资源名称去拿资源对应的ID
//                val resId = resources.getIdentifier("face_base_001", "drawable", packageName)
//                if (resId == 0) continue
//                // 添加表情
//                faces.add(Bean(key, resId))
//            }
//            return if (faces.size == 0) null else FaceTab("emoji", faces[0].source, faces)
//        }
//
//        // 从drawable资源中加载数据并映射到对应的key
//        private fun initSExpression(context: Context): FaceTab? {
//            val faces = ArrayList<Bean>()
//            val resources = context.resources
//
//            // tip：使用反射拿到资源
//            val packageName = context.applicationInfo.packageName
//            var i = 0
//            while (i++ < 10) {
//                val key = String.format(Locale.ENGLISH, "se%02d", i)
//                // 根据资源名称去拿资源对应的ID
//                val resId = resources.getIdentifier("iv_chat_mic", "drawable", packageName)
//                if (resId == 0) continue
//                // 添加表情
//                faces.add(Bean(key, resId))
//            }
//            return if (faces.size == 0) null else FaceTab("小表情", faces[0].source, faces)
//        }
//
//        /**
//         * 获取所有的表情
//         */
//        fun all(context: Context): List<FaceTab?>? {
//            init(context)
//            return FACE_TABS
//        }
//
//        /**
//         * 输入一个表情到editable
//         */
//        fun inputFace(context: Context, editable: Editable,
//                           bean: Bean, size: Int) {
//            Glide.with(context)
//                    .load(bean.source)
//                    .into(object : SimpleTarget<Drawable?>(size, size) {
//                        override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable?>?) {
//                            // tip：Editable和Spannable
//                            val spannable: Spannable = SpannableString(String.format("[%s]", bean.key))
//                            val span = ImageSpan(context, bean.source as Int, ImageSpan.ALIGN_BASELINE)
//                            spannable.setSpan(span, 0, spannable.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//                            editable.append(spannable)
//                        }
//                    })
//        }
//
//        // 拿一个Bean
//        // key:ft001
//        operator fun get(context: Context, key: String): Bean? {
//            init(context)
//            return if (FACE_MAP.containsKey(key)) {
//                FACE_MAP[key]
//            } else null
//        }
//
//        /**
//         * 从Spannable解析表情并替换显示
//         */
//        fun decode(target: View, spannable: Spannable?, size: Int): Spannable? {
//            if (spannable == null) return null
//            val str = spannable.toString()
//            if (TextUtils.isEmpty(str)) return null
//            val context = target.context
//            // 进行正在匹配[][][]
//            // tip:正则匹配
//            val pattern = Pattern.compile("(\\[[^\\[\\]:\\s\\n]+\\])")
//            val matcher = pattern.matcher(str)
//            while (matcher.find()) {
//                val key = matcher.group()
//                if (TextUtils.isEmpty(key)) continue
//                val bean = get(context, key.replace("[", "").replace("]", "")) ?: continue
//                val start = matcher.start()
//                val end = matcher.end()
//                //
//                val span: ImageSpan = FaceSpan(context, target, bean.preview, size)
//                spannable.setSpan(span, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//            }
//            return spannable
//        }
//    }
//
//    // 表情标示
//    class FaceSpan(context: Context, private val mView: View, source: Any?, size: Int) : ImageSpan(context, R.drawable.iv_chat_face_normal, ALIGN_BASELINE) {
//        private var mDrawable: Drawable? = null
//        private val mSize = 0
//        override fun getDrawable(): Drawable {
//            return mDrawable!!
//        }
//
//        override fun getSize(paint: Paint, text: CharSequence, start: Int, end: Int, fm: Paint.FontMetricsInt?): Int {
//            val rect = mDrawable?.getBounds() ?: Rect(0, 0, mSize, mSize)
//            if (fm != null) {
//                fm.ascent = -rect.bottom
//                fm.descent = 0
//                fm.top = fm.ascent
//                fm.bottom = 0
//            }
//            return rect.right
//        }
//
//        override fun draw(canvas: Canvas, text: CharSequence, start: Int, end: Int, x: Float, top: Int, y: Int, bottom: Int, paint: Paint) {
//            if (mDrawable != null) super.draw(canvas, text, start, end, x, top, y, bottom, paint)
//        }
//
//        /**
//         * @param context
//         * @param view    目标View
//         * @param source  加载目标
//         * @param size    图片大小
//         */
//        init {
//            // 默认图片仅占位
//            Glide.with(context)
//                    .load(source)
//                    .fitCenter()
//                    .into(object : SimpleTarget<Drawable?>(size, size) {
//                        override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable?>?) {
//                            mDrawable = resource.current
//                            val width = mDrawable!!.getIntrinsicWidth()
//                            val height = mDrawable!!.getIntrinsicHeight()
//                            mDrawable!!.setBounds(0, 0, if (width > 0) width else size,
//                                    if (height > 0) height else size)
//                            // 通知刷新
//                            mView.invalidate()
//                        }
//                    })
//        }
//    }
//
//    /**
//     * 每一个表情盘，有很多表情
//     */
//    class FaceTab(name: String, preview: Any, faces: List<Bean>) {
//        var faces: List<Bean> = ArrayList()
//        var name: String
//        var preview: Any
//        fun copyToMap(faceMap: ArrayMap<String, Bean>) {
//            for (face in faces) {
//                faceMap[face.key] = face
//            }
//        }
//
//        init {
//            this.faces = faces
//            this.name = name
//            this.preview = preview
//        }
//    }
//
//    /**
//     * 每一个表情
//     */
//    class Bean(var key: String, var source: Any) {
//        var desc: String? = null
//        lateinit var preview: Any
//
//        init {
//            source = source
//        }
//    }
//
//}