package com.awesome.audiorecorddemo.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.awesome.audiorecorddemo.R;

import net.qiujuer.genius.ui.widget.FloatActionButton;


/**
 * 和QQ录音面板类似的控件，充当录音的发起者功能
 * 发起录音-结束录音（正常结束，取消，播放，删除）四种结束方式
 *
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */
public class AudioRecordView extends FrameLayout implements View.OnTouchListener {
    // 相关的结束方式
    // 结束是因为取消
    public static final int END_TYPE_CANCEL = 0;
    // 正常结束
    public static final int END_TYPE_NONE = 1;
    // 结束后想要删除
    public static final int END_TYPE_DELETE = 2;

    // 相关删除／播放按钮的透明度
    private static final float MIN_ALPHA = 0.4f;
    // 触摸的点坐标
    private final float[] mTouchPoint = new float[2];
    // 删除的位置
    private final Rect mDeleteLocation = new Rect();
    // 录制按钮的位置
    private final Rect mRectLocation = new Rect();
    // 浮动的录制按钮
    private ImageView mRecordButton;
    // 删除按钮
    private ImageView mDeleteButton;
    // 标示正在录制的状态
    private boolean mIsRecording;
    // 回调方法
    private Callback mCallback;

    public AudioRecordView(@NonNull Context context) {
        super(context);
        init();
    }

    public AudioRecordView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AudioRecordView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_record_view, this);
        mRecordButton = findViewById(R.id.btn_record);
        mDeleteButton = findViewById(R.id.im_delete);
        mRecordButton.setOnTouchListener(this);
        turnRecord();
    }

    /**
     * 初始化开始方法
     *
     * @param callback 设置一个状态回调
     */
    public void setup(Callback callback) {
        this.mCallback = callback;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        // 当界面改变时得到对应的坐标位置
        mDeleteLocation.left = mDeleteButton.getLeft() - left;
        mDeleteLocation.top = mDeleteButton.getTop() - top;
        mDeleteLocation.right = mDeleteButton.getRight() - left;
        mDeleteLocation.bottom = mDeleteButton.getBottom() - top;

        mRectLocation.left = mRecordButton.getLeft() - left;
        mRectLocation.top = mRecordButton.getTop() - top;
        mRectLocation.right = mRecordButton.getRight() - left;
        mRectLocation.bottom = mRecordButton.getBottom() - top;
    }


    // 切换录音状态
    private void turnRecord() {
        if (mIsRecording) {
            mDeleteButton.animate()
                    .alpha(MIN_ALPHA)
                    .scaleX(1)
                    .scaleY(1)
                    .setDuration(320)
                    .setInterpolator(new AnticipateOvershootInterpolator())
                    .start();
        } else {
            mDeleteButton.animate()
                    .alpha(0)
                    .scaleX(0)
                    .scaleY(0)
                    .setDuration(260)
                    .setInterpolator(new DecelerateInterpolator())
                    .start();
        }
    }

    // 当用户按下按钮时开始进行录音
    private void onStart() {
        this.mIsRecording = true;
        turnRecord();


        Callback callback = mCallback;
        if (callback != null) {
            callback.requestStartRecord();
        }
    }

    // 当松开时结束
    private void onStop(boolean isCancel) {
        if (!mIsRecording)
            return;

        mIsRecording = false;
        turnRecord();

        Callback callback = mCallback;
        if (callback != null) {
            callback.requestStopRecord(isCancel ? END_TYPE_CANCEL :
                    (mActiveView == null ? END_TYPE_NONE : END_TYPE_DELETE));
        }
    }

    // 监听用户的手指触摸，并相应对应的开始，停止，取消等操作
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                // 以录音键的左边界和上边界为圆点，触摸点的x、y坐标
                float pointX = event.getX();
                float pointY = event.getY();

                // mRectLocation.left,该区域的左边界
                mTouchPoint[0] = pointX + mRectLocation.left;
                mTouchPoint[1] = pointY + mRectLocation.top;

                // pointX触摸到圆心左边为ture，触摸到圆心右边为false
                // mRectLocation.centerX(),该区域中心位置的x坐标
                boolean inRight = mTouchPoint[0] > mRectLocation.centerX();

                if (inRight) {
                    double spaceLen = calculatePointDistance(mTouchPoint[0], mTouchPoint[1],
                            mDeleteLocation.centerX(), mDeleteLocation.centerY());
                    refreshAlpha(spaceLen);
                }
                break;
            case MotionEvent.ACTION_DOWN:
                Log.i("jlog", "ACTION_DOWN");
                mRecordButton.setImageResource(R.drawable.iv_mic_pressed);
                mRecordButton.setBackground(getResources().getDrawable(R.drawable.bg_chat_mic_pressed));
                onStart();
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.i("jlog", "ACTION_CANCEL");
                onStop(true);
                break;
            case MotionEvent.ACTION_UP:
                mRecordButton.setImageResource(R.drawable.iv_mic_normal);
                mRecordButton.setBackground(getResources().getDrawable(R.drawable.bg_chat_mic_normal));
                Log.i("jlog", "ACTION_UP");
                onStop(false);
                break;
        }
        return true;
    }

    // 计算两个点之间的距离
    private double calculatePointDistance(float px1, float py1, float px2, float py2) {
        double spaceX = Math.abs(px1 - px2);
        double spaceY = Math.abs(py1 - py2);
        return Math.sqrt(spaceX * spaceX + spaceY * spaceY);
    }

    // 记录最后一次的进度值，当进度值一致时不做刷新
    private float mLastProgress;
    // 当前被激活的布局(播放，或者停止)
    private View mActiveView;

    // 根据手指滑动更改透明度
    private void refreshAlpha(double spaceLen) {
        // 录音键和功能键的距离
        double maxLen = calculatePointDistance(mRectLocation.centerX(), mRectLocation.centerY(),
                mDeleteLocation.centerX(), mDeleteLocation.centerY());

        // 触摸点距离和最大距离的比例
        // Math.round四舍五入
        float progress = Math.round(spaceLen / maxLen * 1000) / 1000f;
        if (mLastProgress == progress)
            return;
        mLastProgress = progress;
        progress = 1 - Math.max(0, Math.min(1, progress));

        float[] touchPoint = mTouchPoint;
        boolean overFlowIcon = mDeleteLocation.contains((int) touchPoint[0], (int) touchPoint[1]);

        ImageView activeView = mDeleteButton;
        activeView.setAlpha(MIN_ALPHA + (1 - MIN_ALPHA) * progress);
        activeView.setImageResource(overFlowIcon ? R.drawable.iv_mic_cancel_enabled : R.drawable.iv_mic_cancel_normal);
        float scale = 1 + 0.2f * progress;
        activeView.setScaleX(scale);
        activeView.setScaleY(scale);
        mActiveView = overFlowIcon ? activeView : null;
    }


    // 回调的状态类
    public interface Callback {
        // 请求开始录音
        void requestStartRecord();

        // 请求结束录音，并携带结束标示
        void requestStopRecord(int type);
    }
}
