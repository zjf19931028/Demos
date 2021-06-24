package com.awesome.uidemo.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;


import com.awesome.sdk.constant.Constant;
import com.awesome.uidemo.bean.KlotskiBean;
import com.awesome.uidemo.bean.Null;
import com.awesome.uidemo.util.Constants;
import com.awesome.uidemo.util.DisplayUtil;
import com.awesome.uidemo.util.KlotskiUtil;

import java.util.Random;

import static com.awesome.uidemo.util.KlotskiUtil.HEIGHT_BLOCK;
import static com.awesome.uidemo.util.KlotskiUtil.WIDTH_BLOCK;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/19 17:21
 * Description:华容道控件
 */
public class KlotskiView extends View {
    private Paint mPaint = new Paint();
    private KlotskiBean[][] mKlotskiBeanArray;
    private boolean mSuccess = false;
    private int mCount;
    private IOnCountCallback mOnCountCallback;
    private Context mContext;
    private KlotskiUtil klotskiUtil;
    private int level;
    private final int AT_MOST_STEP_MAX = 2 ;

    public KlotskiView(Context context) {
        this(context, null);
    }

    public KlotskiView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public KlotskiView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        mPaint.setAntiAlias(true);
        klotskiUtil = new KlotskiUtil(context);
        level = new Random().nextInt(Constants.HIGHEST_LEVEL_CONUT);
        mKlotskiBeanArray = klotskiUtil.getKlotskiBeanArray(level);
    }

    /**
     * 获取随机关卡数的编号
     *
     * @return
     */
    public int getLevel() {
        return level;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int min = Math.min(getContext().getResources().getDisplayMetrics().widthPixels - DisplayUtil.dp2px(mContext, 42), getContext().getResources().getDisplayMetrics().heightPixels);
        int width = min;
        int height = min / 4 * 5;
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int x = 0; x < HEIGHT_BLOCK; x++) {
            int top = getHeight() / HEIGHT_BLOCK * x;
            for (int y = 0; y < WIDTH_BLOCK; y++) {
                int left = getWidth() / WIDTH_BLOCK * y;
                if (mKlotskiBeanArray[x][y].getBitmap() != null) {
                    canvas.drawBitmap(mKlotskiBeanArray[x][y].getBitmap(), left, top, mPaint);
                }
            }
        }
    }

    private float mDownX, mDownY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mSuccess) {
            return true;
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mDownX = event.getX();
                mDownY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                // 按下的当前快
                int perWidth = getWidth() / mKlotskiBeanArray[0].length;
                int x = (int) mDownY / (getHeight() / mKlotskiBeanArray.length);
                int y = (int) mDownX / (getWidth() / mKlotskiBeanArray[x].length);
                if (mKlotskiBeanArray[x][y].getType() == KlotskiBean.Type.NULL) {
                    break;
                }
                boolean moveResult;
                if (Math.abs(event.getX() - mDownX) > Math.abs(event.getY() - mDownY)) {
                    if (event.getX() - mDownX > 0) {
                        // 右滑
                        if ((event.getX() - mDownX)/perWidth>1){
                            moveResult = move2Right(x, y,2);
                        }else {
                            moveResult = move2Right(x, y);
                        }
                    } else {
                        // 左滑
                        moveResult = move2Left(x, y);
                    }
                } else {
                    if (event.getY() - mDownY > 0) {
                        // 下滑
                        moveResult = move2Bottom(x, y);
                    } else {
                        // 上滑
                        moveResult = move2Top(x, y);
                    }
                }
                mDownX = 0;
                mDownY = 0;
                if (mOnCountCallback != null && moveResult) {
                    mOnCountCallback.onCount(++mCount);
                }
                if (mSuccess = success()) {
                    mOnCountCallback.onSuccess();
                }
                break;
        }
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/5/20 18:08
     * Description:移动到左边
     *
     * @param x 触摸的方块在棋盘中的 x 坐标,非绘制坐标
     * @param y 触摸的方块在棋盘中的 y 坐标,非绘制坐标
     */
    private boolean move2Left(int x, int y) {
        // 当前块在最左侧
        if (y == 0) {
            return false;
        }
        // true 需要移动当前块的右边块
        boolean again = false;
        KlotskiBean touchKlotskiBean = mKlotskiBeanArray[x][y];
        // 水平方向的块
        // 有关联块，期望先移动左边块，再移动右边块。当前块是左边块，移动左边块再移动右边块。当前块是右边块，把当前块设置成左边块。
        if (touchKlotskiBean.getWidth() == 2) {
            // 左边是关联块
            if (mKlotskiBeanArray[x][y - 1].getType() == touchKlotskiBean.getType()) {
                return move2Left(x, y - 1);
                // 右边是关联块
            } else if (y < mKlotskiBeanArray[x].length - 1
                    && mKlotskiBeanArray[x][y + 1].getType() == touchKlotskiBean.getType()) {
                again = true;
            }
        }
        // 垂直方向的块
        if (touchKlotskiBean.getHeight() == 1) {
            moveCurrentBlock(x,y,x,y-1);
        } else if (touchKlotskiBean.getHeight() == 2) {
            // 关联块
            if (x == 0) {
                // 当前块在最上方，关联块在下方
                moveCurrentAndRelationBlock(x,y,x,y-1,x+1,y,x+1,y-1);
            } else if (x == mKlotskiBeanArray.length - 1) {
                // 当前块在最下方，关联块在上方
                moveCurrentAndRelationBlock(x,y,x,y-1,x-1,y,x-1,y-1);
            } else {
                /// 关联块在中间
                if (mKlotskiBeanArray[x - 1][y].getType() == touchKlotskiBean.getType()) {
                    // 关联块在上方
                    moveCurrentAndRelationBlock(x,y,x,y-1,x-1,y,x-1,y-1);
                } else if (mKlotskiBeanArray[x + 1][y].getType() == touchKlotskiBean.getType()) {
                    // 关联块在下方
                    moveCurrentAndRelationBlock(x,y,x,y-1,x+1,y,x+1,y-1);
                }
            }
        }
        if (again) {
            move2Left(x, y + 1);
        }
        invalidate();
        return true;
    }


    private boolean move2Right(int x, int y,int atMostStep) {
        // 当前块在最右侧
        if (atMostStep == 2){
            if (y == mKlotskiBeanArray[x].length - 2) {
                atMostStep = 1;
            }
        }
        if (y == mKlotskiBeanArray[x].length - 1) {
            return false;
        }
        // true 需要移动当前块的左边块
        boolean again = false;
        KlotskiBean touchKlotskiBean = mKlotskiBeanArray[x][y];
        /// 水平方向的块
        /// 有关联块，期望先移动右边块，再移动左边块。当前块是右边块，移动右边块再移动左边块。当前块是左边块，把当前块设置成右边块。
        if (touchKlotskiBean.getWidth() == 2) {
            if (y > 0 && mKlotskiBeanArray[x][y - 1].getType() == touchKlotskiBean.getType()) {
                again = true;
            } else if (mKlotskiBeanArray[x][y + 1].getType() == touchKlotskiBean.getType()) {
                return move2Right(x, y + 1);
            }
        }
        /// 垂直方向的块
        if (touchKlotskiBean.getHeight() == 1) {
            /// 当前块右边块是否有位置
            if (atMostStep == 2){
                if (mKlotskiBeanArray[x][y + 2].getType() != KlotskiBean.Type.NULL) {
                    atMostStep = 1;
                }
            }
            if (mKlotskiBeanArray[x][y + 1].getType() != KlotskiBean.Type.NULL) {
                return false;
            }
            /// 移动当前块
            mKlotskiBeanArray[x][y + atMostStep] = touchKlotskiBean;
            mKlotskiBeanArray[x][y] = new Null();
        } else if (touchKlotskiBean.getHeight() == 2) {
            if (mKlotskiBeanArray[x][y + 1].getType() != KlotskiBean.Type.NULL) {
                return false;
            }
            if (x == 0) {
                if (mKlotskiBeanArray[x + 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                    return false;
                }
                mKlotskiBeanArray[x][y + 1] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = new Null();
                mKlotskiBeanArray[x + 1][y + 1] = mKlotskiBeanArray[x + 1][y];
                mKlotskiBeanArray[x + 1][y] = new Null();
            } else if (x == mKlotskiBeanArray.length - 1) {
                if (mKlotskiBeanArray[x - 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                    return false;
                }
                mKlotskiBeanArray[x][y + 1] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = new Null();
                mKlotskiBeanArray[x - 1][y + 1] = mKlotskiBeanArray[x - 1][y];
                mKlotskiBeanArray[x - 1][y] = new Null();
            } else {
                if (mKlotskiBeanArray[x - 1][y].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x - 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                        return false;
                    }
                    mKlotskiBeanArray[x][y + 1] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = new Null();
                    mKlotskiBeanArray[x - 1][y + 1] = mKlotskiBeanArray[x - 1][y];
                    mKlotskiBeanArray[x - 1][y] = new Null();
                } else if (mKlotskiBeanArray[x + 1][y].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x + 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                        return false;
                    }
                    mKlotskiBeanArray[x][y + 1] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = new Null();
                    mKlotskiBeanArray[x + 1][y + 1] = mKlotskiBeanArray[x + 1][y];
                    mKlotskiBeanArray[x + 1][y] = new Null();
                }
            }
        }
        if (again) {
            move2Right(x, y - 1);
        }
        invalidate();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/5/20 18:08
     * Description:移动到右边
     *
     * @param x 触摸的方块在棋盘中的 x 坐标,非绘制坐标
     * @param y 触摸的方块在棋盘中的 y 坐标,非绘制坐标
     */
    private boolean move2Right(int x, int y) {
        // 当前块在最右侧
        if (y == mKlotskiBeanArray[x].length - 1) {
            return false;
        }
        // true 需要移动当前块的左边块
        boolean again = false;
        KlotskiBean touchKlotskiBean = mKlotskiBeanArray[x][y];
        /// 水平方向的块
        /// 有关联块，期望先移动右边块，再移动左边块。当前块是右边块，移动右边块再移动左边块。当前块是左边块，把当前块设置成右边块。
        if (touchKlotskiBean.getWidth() == 2) {
            if (y > 0 && mKlotskiBeanArray[x][y - 1].getType() == touchKlotskiBean.getType()) {
                again = true;
            } else if (mKlotskiBeanArray[x][y + 1].getType() == touchKlotskiBean.getType()) {
                return move2Right(x, y + 1);
            }
        }
        /// 垂直方向的块
        if (touchKlotskiBean.getHeight() == 1) {
            /// 当前块右边块是否有位置
            if (mKlotskiBeanArray[x][y + 1].getType() != KlotskiBean.Type.NULL) {
                return false;
            }
            /// 移动当前块
            mKlotskiBeanArray[x][y + 1] = touchKlotskiBean;
            mKlotskiBeanArray[x][y] = new Null();
        } else if (touchKlotskiBean.getHeight() == 2) {
            if (mKlotskiBeanArray[x][y + 1].getType() != KlotskiBean.Type.NULL) {
                return false;
            }
            if (x == 0) {
                if (mKlotskiBeanArray[x + 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                    return false;
                }
                mKlotskiBeanArray[x][y + 1] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = new Null();
                mKlotskiBeanArray[x + 1][y + 1] = mKlotskiBeanArray[x + 1][y];
                mKlotskiBeanArray[x + 1][y] = new Null();
            } else if (x == mKlotskiBeanArray.length - 1) {
                if (mKlotskiBeanArray[x - 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                    return false;
                }
                mKlotskiBeanArray[x][y + 1] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = new Null();
                mKlotskiBeanArray[x - 1][y + 1] = mKlotskiBeanArray[x - 1][y];
                mKlotskiBeanArray[x - 1][y] = new Null();
            } else {
                if (mKlotskiBeanArray[x - 1][y].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x - 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                        return false;
                    }
                    mKlotskiBeanArray[x][y + 1] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = new Null();
                    mKlotskiBeanArray[x - 1][y + 1] = mKlotskiBeanArray[x - 1][y];
                    mKlotskiBeanArray[x - 1][y] = new Null();
                } else if (mKlotskiBeanArray[x + 1][y].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x + 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                        return false;
                    }
                    mKlotskiBeanArray[x][y + 1] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = new Null();
                    mKlotskiBeanArray[x + 1][y + 1] = mKlotskiBeanArray[x + 1][y];
                    mKlotskiBeanArray[x + 1][y] = new Null();
                }
            }
        }
        if (again) {
            move2Right(x, y - 1);
        }
        invalidate();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/5/20 18:08
     * Description:移动到上面
     *
     * @param x 触摸的方块在棋盘中的 x 坐标,非绘制坐标
     * @param y 触摸的方块在棋盘中的 y 坐标,非绘制坐标
     */
    private boolean move2Top(int x, int y) {
        if (x == 0) {
            return false;
        }
        boolean again = false;
        KlotskiBean touchKlotskiBean = mKlotskiBeanArray[x][y];
        if (touchKlotskiBean.getHeight() == 2) {
            if (mKlotskiBeanArray[x - 1][y].getType() == touchKlotskiBean.getType()) {
                return move2Top(x - 1, y);
            } else if (x < mKlotskiBeanArray.length - 1 &&
                    mKlotskiBeanArray[x + 1][y].getType() == touchKlotskiBean.getType()) {
                again = true;
            }
        }
        if (touchKlotskiBean.getWidth() == 1) {
            if (mKlotskiBeanArray[x - 1][y].getType() != KlotskiBean.Type.NULL) {
                return false;
            }
            mKlotskiBeanArray[x - 1][y] = touchKlotskiBean;
            mKlotskiBeanArray[x][y] = new Null();
        } else if (touchKlotskiBean.getWidth() == 2) {
            if (mKlotskiBeanArray[x - 1][y].getType() != KlotskiBean.Type.NULL) {
                return false;
            }
            if (y == 0) {
                if (mKlotskiBeanArray[x - 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                    return false;
                }
                mKlotskiBeanArray[x - 1][y] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = new Null();
                mKlotskiBeanArray[x - 1][y + 1] = mKlotskiBeanArray[x][y + 1];
                mKlotskiBeanArray[x][y + 1] = new Null();
            } else if (y == mKlotskiBeanArray.length - 1) {
                if (mKlotskiBeanArray[x - 1][y - 1].getType() != KlotskiBean.Type.NULL) {
                    return false;
                }
                mKlotskiBeanArray[x - 1][y] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = new Null();
                mKlotskiBeanArray[x - 1][y - 1] = mKlotskiBeanArray[x][y - 1];
                mKlotskiBeanArray[x][y - 1] = new Null();
            } else {
                if (mKlotskiBeanArray[x][y - 1].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x - 1][y - 1].getType() != KlotskiBean.Type.NULL) {
                        return false;
                    }
                    mKlotskiBeanArray[x - 1][y] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = new Null();
                    mKlotskiBeanArray[x - 1][y - 1] = mKlotskiBeanArray[x][y - 1];
                    mKlotskiBeanArray[x][y - 1] = new Null();
                } else if (mKlotskiBeanArray[x][y + 1].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x - 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                        return false;
                    }
                    mKlotskiBeanArray[x - 1][y] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = new Null();
                    mKlotskiBeanArray[x - 1][y + 1] = mKlotskiBeanArray[x][y + 1];
                    mKlotskiBeanArray[x][y + 1] = new Null();
                }
            }
        }
        if (again) {
            move2Top(x + 1, y);
        }
        invalidate();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/5/20 18:08
     * Description:移动到下面
     *
     * @param x 触摸的方块在棋盘中的 x 坐标,非绘制坐标
     * @param y 触摸的方块在棋盘中的 y 坐标,非绘制坐标
     */
    private boolean move2Bottom(int x, int y) {
        if (x == mKlotskiBeanArray.length - 1) {
            return false;
        }
        boolean again = false;
        KlotskiBean touchKlotskiBean = mKlotskiBeanArray[x][y];
        if (touchKlotskiBean.getHeight() == 2) {
            if (x > 0
                    && mKlotskiBeanArray[x - 1][y].getType() == touchKlotskiBean.getType()) {
                again = true;
            } else if (mKlotskiBeanArray[x + 1][y].getType() == touchKlotskiBean.getType()) {
                return move2Bottom(x + 1, y);
            }
        }
        if (touchKlotskiBean.getWidth() == 1) {
            if (mKlotskiBeanArray[x + 1][y].getType() != KlotskiBean.Type.NULL) {
                return false;
            }
            mKlotskiBeanArray[x + 1][y] = touchKlotskiBean;
            mKlotskiBeanArray[x][y] = new Null();
        } else if (touchKlotskiBean.getWidth() == 2) {
            if (mKlotskiBeanArray[x + 1][y].getType() != KlotskiBean.Type.NULL) {
                return false;
            }
            if (y == 0) {
                if (mKlotskiBeanArray[x + 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                    return false;
                }
                mKlotskiBeanArray[x + 1][y] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = new Null();
                mKlotskiBeanArray[x + 1][y + 1] = mKlotskiBeanArray[x][y + 1];
                mKlotskiBeanArray[x][y + 1] = new Null();
            } else if (y == mKlotskiBeanArray.length - 1) {
                if (mKlotskiBeanArray[x + 1][y - 1].getType() != KlotskiBean.Type.NULL) {
                    return false;
                }
                mKlotskiBeanArray[x + 1][y] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = new Null();
                mKlotskiBeanArray[x + 1][y - 1] = mKlotskiBeanArray[x][y - 1];
                mKlotskiBeanArray[x][y - 1] = new Null();
            } else {
                if (mKlotskiBeanArray[x][y - 1].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x + 1][y - 1].getType() != KlotskiBean.Type.NULL) {
                        return false;
                    }
                    mKlotskiBeanArray[x + 1][y] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = new Null();
                    mKlotskiBeanArray[x + 1][y - 1] = mKlotskiBeanArray[x][y - 1];
                    mKlotskiBeanArray[x][y - 1] = new Null();
                } else if (mKlotskiBeanArray[x][y + 1].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x + 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                        return false;
                    }
                    mKlotskiBeanArray[x + 1][y] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = new Null();
                    mKlotskiBeanArray[x + 1][y + 1] = mKlotskiBeanArray[x][y + 1];
                    mKlotskiBeanArray[x][y + 1] = new Null();
                }
            }
        }
        if (again) {
            move2Bottom(x - 1, y);
        }
        invalidate();
        return true;
    }

    /**
     * 移动当前块
     *
     * @return 移动的位置是否为NULL块
     */
    private boolean moveCurrentBlock(int sourceX, int sourceY, int targetX, int targetY) {
        if (mKlotskiBeanArray[targetX][targetY].getType() != KlotskiBean.Type.NULL) {
            return false;
        }
        mKlotskiBeanArray[targetX][targetY] = mKlotskiBeanArray[sourceX][sourceY];
        mKlotskiBeanArray[sourceX][sourceY] = new Null();
        return true;
    }

    /**
     * 移动当前块和关联块
     *
     * @return 移动的位置是否为NULL块
     */
    private boolean moveCurrentAndRelationBlock(int sourceX, int sourceY, int targetX, int targetY,
                                                int relationSourceX, int relationSourceY,
                                                int relationTargetX, int relationTargetY) {
        if (mKlotskiBeanArray[targetX][targetY].getType() != KlotskiBean.Type.NULL) {
            return false;
        }
        if (mKlotskiBeanArray[relationTargetX][relationTargetY].getType() != KlotskiBean.Type.NULL) {
            return false;
        }
        /// 移动当前块
        /// 移动关联块
        mKlotskiBeanArray[targetX][targetY] = mKlotskiBeanArray[sourceX][sourceY];
        mKlotskiBeanArray[sourceX][sourceY] = new Null();
        mKlotskiBeanArray[relationTargetX][relationTargetY] = mKlotskiBeanArray[relationSourceX][relationSourceY];
        mKlotskiBeanArray[relationSourceX][relationSourceY] = new Null();
        return true;
    }


    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/5/20 18:30
     * Description:判断是否成功,曹操在棋盘最下面的中间时,即为解密成功
     *
     * @return 是否解密成功
     */
    private boolean success() {
        return mKlotskiBeanArray[4][1].getType() == KlotskiBean.Type.CAO_CAO && mKlotskiBeanArray[4][2].getType() == KlotskiBean.Type.CAO_CAO;
    }

    /**
     * 重置界面
     */
    public void resetKlotski(int level) {
        this.level = level;
        mKlotskiBeanArray = klotskiUtil.getKlotskiBeanArray(level);
        mSuccess = false;
        mCount = 0;
        invalidate();
    }

    public void setOnCountCallback(IOnCountCallback onCountCallback) {
        mOnCountCallback = onCountCallback;
    }

    public interface IOnCountCallback {
        void onCount(int count);

        //游戏成功回调
        void onSuccess();
    }
}
