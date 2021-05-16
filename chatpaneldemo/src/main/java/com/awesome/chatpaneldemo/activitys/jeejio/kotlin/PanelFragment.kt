//package com.awesome.chatpaneldemo.activitys.jeejio.kotlin
//
//import android.view.KeyEvent
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.EditText
//import android.widget.LinearLayout
//import androidx.recyclerview.widget.GridLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import androidx.viewpager.widget.PagerAdapter
//import androidx.viewpager.widget.ViewPager
//import com.google.android.material.tabs.TabLayout
//import com.jeejio.pub.base.WTFragment
//import com.jeejio.wutong.R
//import com.jeejio.wutong.chat.adapter.FaceAdapter
//import com.jeejio.wutong.chat.bean.Face
//import com.jeejio.wutong.chat.contract.IPanelContract
//import com.jeejio.wutong.chat.presenter.PanelPresenter
//import com.jeejio.wutong.chat.util.Ui
//import com.jeejio.wutong.chat.util.UiTool
//
///**
// * Author: zhangjingfang
// * Email:zhangjingfang@jeejio.com
// * Date: 2021/05/13 15:37
// * Description:
// */
//class PanelFragment() : WTFragment<IPanelContract.IView, PanelPresenter, Any?>(),
//        IPanelContract.IView {
//    private val mFacePanel by lazy { findViewById<LinearLayout>(R.id.layout_panel_face) }
//    private var mGalleryPanel: android.view.View? = null
//    private var mRecordPanel: android.view.View? = null
//    private var mCallback: PanelCallback? = null
//    override fun initLayoutId() = R.layout.fragment_panel
//
//    override fun initView() {
//        initFace()
//        initRecord()
//        initGallery()
//    }
//
//
//    override fun setListener() {
//
//    }
//
//    override fun initData() {
//
//    }
//
//    private fun initFace() {
//        val viewBackspace by lazy { findViewById<View>(R.id.btn_backspace) }
//        val viewSend by lazy { findViewById<View>(R.id.btn_send) }
//        val llDoFace by lazy { findViewById<LinearLayout>(R.id.ll_do_face) }
//        val tabLayout by lazy { findViewById<TabLayout>(R.id.tab) }
//        val viewPager by lazy { findViewById<ViewPager>(R.id.pager) }
//        viewBackspace.setOnClickListener {
//            // 删除逻辑
//
//            // 删除逻辑
//            val callback = mCallback
////            if (callback == null)
////                return
//            // 模拟一个键盘删除点击
//            // 模拟一个键盘删除点击
//            val event = KeyEvent(0, 0, 0, KeyEvent.KEYCODE_DEL,
//                    0, 0, 0, 0, KeyEvent.KEYCODE_ENDCALL)
//            callback?.getInputEditText()?.dispatchKeyEvent(event)
//        }
//        viewSend.setOnClickListener(View.OnClickListener { })
//        tabLayout.setupWithViewPager(viewPager)
//        // 每一表情显示48dp
//        // 每一表情显示48dp
//        val totalScreen: Int = UiTool.getScreenWidth(activity)
//        val spanCount = totalScreen / Ui.dipToPx(resources, 48f)
//
//        // 每一表情显示96dp
//
//        // 每一表情显示96dp
//        val sETotalScreen: Int = UiTool.getScreenWidth(activity)
//        val sESpanCount = sETotalScreen / Ui.dipToPx(resources, 96f)
//
//        viewPager.adapter = object :PagerAdapter(){
//            override fun getCount(): Int {
//                return Face.all(context!!)?.size!!
//            }
//
//            override fun isViewFromObject(view: View, `object`: Any): Boolean {
//                return view === `object`
//            }
//            override fun instantiateItem(container: ViewGroup, position: Int): Any {
//                val inflater = LayoutInflater.from(context)
//                val recyclerView = inflater.inflate(R.layout.item_chat_face_content, container, false) as RecyclerView
//                if (position == 0) {
//                    recyclerView.layoutManager = GridLayoutManager(context, spanCount.toInt())
//                } else {
//                    recyclerView.layoutManager = GridLayoutManager(context, sESpanCount.toInt())
//                }
//
//                // 设置Adapter
//                val faces: List<Face.Bean> = Face.all(context!!)?.get(position)!!.faces
//                val adapter = FaceAdapter(faces)
//                recyclerView.adapter = adapter
//
//                // 添加
//                container.addView(recyclerView)
//                return recyclerView
//            }
//
//            override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//                container.removeView(container)
//            }
//            override fun getPageTitle(position: Int): CharSequence? {
//                return Face.all(context!!)?.get(position)?.name
//            }
//        }
//    }
//
//    private fun initRecord() {
//    }
//
//    private fun initGallery() {
//    }
//
//    fun showFace() {
//        mFacePanel.visibility = View.VISIBLE
//    }
//
//    fun showRecord() {}
//
//    fun showGallery() {}
//
//    fun hideAll() {
//        mFacePanel.visibility = View.GONE
//    }
//
//    fun setup(callback: PanelCallback) {
//        mCallback = callback
//    }
//
//    interface PanelCallback {
//        fun getInputEditText(): EditText?
//    }
//
//
//}