package com.awesome.chatpaneldemo.activitys.jeejio.kotlin
//
//import android.Manifest
//import android.graphics.Color
//import android.view.*
//import android.widget.*
//import com.jeejio.common.util.log.ShowLogUtil
//import com.jeejio.common.util.permissionutil.OnRequestPermissionResultCallBack
//import com.jeejio.common.util.permissionutil.PermissionUtil
//import com.jeejio.common.util.ui.KeyboardUtil
//import com.jeejio.pub.base.WTActivity
//import com.jeejio.pub.util.ToastUtil
//import com.jeejio.wutong.R
//import com.jeejio.wutong.chat.adapter.GestureListenerAdapter
//import com.jeejio.wutong.chat.contract.IChatInputContract
//import com.jeejio.wutong.chat.presenter.ChatInputPresenter
//import com.jeejio.wutong.chat.util.MediaRecorderManager
//import com.jeejio.wutong.chat.view.fragment.PanelFragment
//
///**
// * Author: JfangZ
// * Email: zhangjingfang@jeejio.com
// * Date: 2021/5/8 10:05
// * Description: 仅使用聊天输入框功能，后期并入聊天界面
// */
//class ChatInputActivity : WTActivity<IChatInputContract.IView, ChatInputPresenter>(), IChatInputContract.IView ,PanelFragment.PanelCallback {
//    private val mLlChat by lazy { findViewById<LinearLayout>(R.id.ll_chat) }
//    private val mTvChatLongPressed by lazy { findViewById<TextView>(R.id.tv_chat_long_pressed) }
//    private val mLlOperation by lazy { findViewById<LinearLayout>(R.id.ll_operation) }
//    private val mBtnRecord by lazy { findViewById<ImageView>(R.id.btn_record) }
//    private val mEtInput by lazy { findViewById<EditText>(R.id.et_input) }
//    private val mBtnFace by lazy { findViewById<ImageView>(R.id.btn_face) }
//    private val mBtnMore by lazy { findViewById<ImageView>(R.id.btn_more) }
////    private val mLlRecord by lazy { findViewById<LinearLayout>(R.id.ll_record) }
////    private val mTvSpeak by lazy { findViewById<TextView>(R.id.tv_speak) }
//    var mPanelFragment: PanelFragment? = null
//
//    override fun initLayoutId() = R.layout.activity_chat_input
//
//    override fun initView() {
//        mPanelFragment = supportFragmentManager.findFragmentById(R.id.frag_panel) as PanelFragment?
//        mPanelFragment?.setup(this)
//    }
//
//    override fun setListener() {
//        mTvChatLongPressed.setOnLongClickListener(object : View.OnLongClickListener {
//            override fun onLongClick(v: View?): Boolean {
//                showPopupWindow()
//                return false
//            }
//        })
//        mBtnFace.setOnClickListener {
//            hideKeyBoard()
//            mPanelFragment?.showFace()
//        }
//        mLlChat.setOnClickListener {
//            hideKeyBoard()
//            mPanelFragment?.hideAll()
//        }
//        mBtnRecord.setOnClickListener {
//            hideKeyBoard()
//            mPanelFragment?.showRecord()
//        }
//        mEtInput.setOnTouchListener(object :View.OnTouchListener{
//            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
//                when(event?.action){
//                    MotionEvent.ACTION_DOWN ->{
//                       mPanelFragment?.hideAll()
//                    }
//                }
//                return false
//            }
//        })
//        var isShortPress = false
//        val gestureDetector = GestureDetector(this, object : GestureListenerAdapter() {
//            override fun onSingleTapUp(e: MotionEvent?): Boolean {
//                isShortPress = true
//                return false
//            }
//        })
//
////        mTvSpeak.setOnTouchListener(View.OnTouchListener { v, event ->
////            isShortPress = false
////            gestureDetector.onTouchEvent(event);
////            when (event.action) {
////                MotionEvent.ACTION_DOWN -> {
////                    ShowLogUtil.info("ACTION_DOWN")
////                    getPermissionAndRecord();
////                    mTvSpeak.setBackgroundColor(Color.BLUE)
////                }
////
////                MotionEvent.ACTION_UP -> {
////                    ShowLogUtil.info("ACTION_UP")
////                    mTvSpeak.setBackgroundColor(Color.parseColor("#cccccc"))
////                    MediaRecorderManager.SINGLETON.stopRecord()
////                    if (isShortPress) {
////                        ShowLogUtil.info("这是一个短点击")
////                    } else {
////                        ShowLogUtil.info("这是一个长点击")
////                    }
////                }
////            }
////            true
////        })
//    }
//
//    override fun initData() {
//    }
//
//    /**
//     * 展示PopupWindow
//     * 长按更多（转发、回复（需要修改输入框，聊天气泡）、删除、分享等）
//     */
//    fun showPopupWindow() {
//        val window = PopupWindow()
//        val contentView = LayoutInflater.from(this@ChatInputActivity).inflate(R.layout.ppw_chat_long_press, null)
//        // popupWindow点击事件
//        ppwClick(contentView, window)
//        window.contentView = contentView
//        contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
//        window.width = contentView.measuredWidth
//        window.height = contentView.measuredHeight
//        window.isFocusable = true
//        window.isOutsideTouchable = true
//        window.showAtLocation(mTvChatLongPressed, Gravity.TOP, 25, 200)
//    }
//
//    /**
//     * popup弹窗中的点击事件
//     */
//    fun ppwClick(view: View, window: PopupWindow) {
//        view.findViewById<TextView>(R.id.tv_copy).setOnClickListener {
//            ShowLogUtil.info("复制")
//            window.dismiss()
//        }
//        view.findViewById<TextView>(R.id.tv_forward).setOnClickListener {
//            ShowLogUtil.info("转发")
//            window.dismiss()
//        }
//        view.findViewById<TextView>(R.id.tv_recall).setOnClickListener {
//            ShowLogUtil.info("撤回")
//            window.dismiss()
//        }
//        view.findViewById<TextView>(R.id.tv_delete).setOnClickListener {
//            ShowLogUtil.info("删除")
//            window.dismiss()
//        }
//        view.findViewById<TextView>(R.id.tv_reply).setOnClickListener {
//            ShowLogUtil.info("回复")
//            window.dismiss()
//        }
//    }
//
//    /**
//     * 隐藏软键盘
//     */
//    fun hideKeyBoard() {
//        if (KeyboardUtil.isKeyboardShown(this@ChatInputActivity)) {
//            KeyboardUtil.hideKeyboard(this@ChatInputActivity)
//        }
//    }
//
////    /**
////     * 展示聊天面板的布局参数
////     */
////    fun chatPanelLayoutParams() {
////        var lp: RelativeLayout.LayoutParams = mLlOperation.layoutParams as RelativeLayout.LayoutParams
////        lp.removeRule(RelativeLayout.ABOVE)
////        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
////        mLlOperation.layoutParams = lp
////    }
//
////    /**
////     * 展示聊天面板和录音的布局参数
////     */
////    fun chatPanelARecordLayoutParams() {
////        var lp: RelativeLayout.LayoutParams = mLlOperation.layoutParams as RelativeLayout.LayoutParams
////        lp.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
////        lp.addRule(RelativeLayout.ABOVE, R.id.ll_record)
////        mLlOperation.layoutParams = lp
////    }
//
//
//    /**
//     * 过去到权限之后去录音
//     */
//    fun getPermissionAndRecord() {
//        if (!PermissionUtil.isGranted(this, Manifest.permission.RECORD_AUDIO) ||
//                !PermissionUtil.isGranted(this, Manifest.permission.RECORD_AUDIO)) {
//            PermissionUtil.requestOnce(this, supportFragmentManager, object : OnRequestPermissionResultCallBack {
//                override fun onSuccess() {
//                    record()
//                }
//
//                override fun onFailure(p0: MutableList<String>?, p1: MutableList<String>?) {
//                    ToastUtil.show("还没有权限")
//                }
//
//            }, Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE)
//        } else {
//            record()
//        }
//    }
//
//    /**
//     * 录音
//     */
//    fun record() {
//        MediaRecorderManager.SINGLETON.startRecord(object : MediaRecorderManager.IOnMediaRecordListener {
//            override fun onStart() {
//                ShowLogUtil.info("开始录音啦")
//            }
//
//            override fun onStop() {
//                ShowLogUtil.info("结束录音啦")
//            }
//
//            override fun onError(e: Exception?) {
//                ShowLogUtil.info("录音出错啦")
//            }
//
//            override fun onVolumeChange(curVolume: Int) {
//                ShowLogUtil.info("录音声音变化啦 $curVolume")
//            }
//        })
//    }
//
//    override fun getInputEditText(): EditText? {
//        return mEtInput
//    }
//
//}