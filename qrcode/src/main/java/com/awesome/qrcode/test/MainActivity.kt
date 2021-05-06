package com.awesome.qrcode.test

import android.os.Bundle
import android.view.SurfaceView
import com.awesome.qrcode.*

class MainActivity : BaseActivity() {
    private var mCaptureHelper: CaptureHelper? = null
    private var mSurfaceView: SurfaceView? = null
    private var mViewfinderView: ViewfinderView? = null

    // 可以弹出二维码解析错误
    private val canPopQRCodeError = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mSurfaceView = findViewById(R.id.surface_view)
        mViewfinderView = findViewById(R.id.viewfinder_view)

        if (!hasPermission(*Constant.CAMERA_PERMISSION)){
            requestPermission(Constant.CAMERA, *Constant.CAMERA_PERMISSION)
        }else{
            initCamera();
        }
    }

    /**
     * 初始化相机
     */
    private fun initCamera() {
        mCaptureHelper = CaptureHelper(this, mSurfaceView, mViewfinderView, null)
        // 设置只识别二维码会提升速度
        mCaptureHelper!!.decodeFormats(DecodeFormatManager.QR_CODE_FORMATS)
        // 播放声音
        mCaptureHelper!!.playBeep(true)
        // 关闭自动重新预览
        mCaptureHelper!!.autoRestartPreviewAndDecode(false)
        // 关闭连续扫描
        mCaptureHelper!!.continuousScan(false)
//        mCaptureHelper!!.setOnCaptureCallback(this)
        mCaptureHelper!!.onCreate()
        mCaptureHelper!!.onResume()
    }

}