package com.awesome.uidemo.util;

import android.content.Context;

import com.awesome.uidemo.R;
import com.awesome.uidemo.bean.CaoCao1;
import com.awesome.uidemo.bean.CaoCao2;
import com.awesome.uidemo.bean.CaoCao3;
import com.awesome.uidemo.bean.CaoCao4;
import com.awesome.uidemo.bean.GuanYu1;
import com.awesome.uidemo.bean.GuanYu2;
import com.awesome.uidemo.bean.HuangZhong1;
import com.awesome.uidemo.bean.HuangZhong2;
import com.awesome.uidemo.bean.KlotskiBean;
import com.awesome.uidemo.bean.MaChao1;
import com.awesome.uidemo.bean.MaChao2;
import com.awesome.uidemo.bean.Null;
import com.awesome.uidemo.bean.ShiBing;
import com.awesome.uidemo.bean.ZhangFei1;
import com.awesome.uidemo.bean.ZhangFei2;
import com.awesome.uidemo.bean.ZhaoYun1;
import com.awesome.uidemo.bean.ZhaoYun2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.awesome.uidemo.app.App;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/20 18:45
 * Description:华容道工具类
 */
public class KlotskiUtil {
    //宽度的块数
    public static final int WIDTH_BLOCK = 4;
    //高度的块数
    public static final int HEIGHT_BLOCK = 5;
    //存储对应块的人物
    private KlotskiBean[][] kArray = new KlotskiBean[HEIGHT_BLOCK][WIDTH_BLOCK];
    //4大将军
    private List<KlotskiBean> fourGeneral = new ArrayList<>();
    //根据将军类型，得到将军下一半
    private Map<KlotskiBean.Type, KlotskiBean> findGeneral = new HashMap<>();
    //关卡名称
    private Map<Integer, String> levelName = new HashMap<>();
    //空类型的块
    private Null mNull1;
    private Null mNull2;
    //士兵类型的块
    private ShiBing mShiBing1;
    private ShiBing mShiBing2;
    private ShiBing mShiBing3;
    private ShiBing mShiBing4;
    //关羽类型的块
    private GuanYu1 mGuanYu1;
    private GuanYu2 mGuanYu2;
    private Context mContext;
    //曹操类型的块
    private CaoCao1 mCaoCao1;
    private CaoCao2 mCaoCao2;
    private CaoCao3 mCaoCao3;
    private CaoCao4 mCaoCao4;

    public KlotskiUtil(Context context) {
        mContext = context;
        //初始化4大将军
        fourGeneral.add(new ZhangFei1(App.getInstance()));
        fourGeneral.add(new HuangZhong1(App.getInstance()));
        fourGeneral.add(new MaChao1(App.getInstance()));
        fourGeneral.add(new ZhaoYun1(App.getInstance()));
        //初始化将军对应的下一半
        findGeneral.put(new ZhangFei1(App.getInstance()).getType(), new ZhangFei2(App.getInstance()));
        findGeneral.put(new HuangZhong1(App.getInstance()).getType(), new HuangZhong2(App.getInstance()));
        findGeneral.put(new MaChao1(App.getInstance()).getType(), new MaChao2(App.getInstance()));
        findGeneral.put(new ZhaoYun1(App.getInstance()).getType(), new ZhaoYun2(App.getInstance()));

        //初始化空类型的块
        mNull1 = new Null();
        mNull2 = new Null();
        //初始化士兵类型的块
        mShiBing1 = new ShiBing(App.getInstance());
        mShiBing2 = new ShiBing(App.getInstance());
        mShiBing3 = new ShiBing(App.getInstance());
        mShiBing4 = new ShiBing(App.getInstance());
        //初始化关羽类型的块
        mGuanYu1 = new GuanYu1(App.getInstance());
        mGuanYu2 = new GuanYu2(App.getInstance());
        //初始化曹操类型的块
        mCaoCao1 = new CaoCao1(App.getInstance());
        mCaoCao2 = new CaoCao2(App.getInstance());
        mCaoCao3 = new CaoCao3(App.getInstance());
        mCaoCao4 = new CaoCao4(App.getInstance());
        //打乱4大将军的顺序
        Collections.shuffle(fourGeneral);
    }

    public KlotskiBean[][] getKlotskiBeanArray(int level) {
        //将曹操加入对应块，曹操在每局开始时的位置不变
        kArray[0][1] = mCaoCao1;
        kArray[0][2] = mCaoCao2;
        kArray[1][1] = mCaoCao3;
        kArray[1][2] = mCaoCao4;
        switch (level) {
            case 0:// 横刀立马
                levelName.put(level, mContext.getResources().getString(R.string.level0));
                kArray[0][0] = fourGeneral.get(0);
                kArray[1][0] = findGeneral.get(fourGeneral.get(0).getType());
                kArray[2][0] = fourGeneral.get(1);
                kArray[3][0] = findGeneral.get(fourGeneral.get(1).getType());
                kArray[4][0] = mShiBing1;
                kArray[2][1] = mGuanYu1;
                kArray[3][1] = mNull1;
                kArray[4][1] = mShiBing2;
                kArray[2][2] = mGuanYu2;
                kArray[3][2] = mShiBing3;
                kArray[4][2] = mNull2;
                kArray[0][3] = fourGeneral.get(2);
                kArray[1][3] = findGeneral.get(fourGeneral.get(2).getType());
                kArray[2][3] = fourGeneral.get(3);
                kArray[3][3] = findGeneral.get(fourGeneral.get(3).getType());
                kArray[4][3] = mShiBing4;
                break;
            case 1:// 指挥若定
                levelName.put(level, mContext.getResources().getString(R.string.level1));
                kArray[0][0] = fourGeneral.get(0);
                kArray[1][0] = findGeneral.get(fourGeneral.get(0).getType());
                kArray[2][0] = mShiBing1;
                kArray[3][0] = fourGeneral.get(1);
                kArray[4][0] = findGeneral.get(fourGeneral.get(1).getType());
                kArray[2][1] = mGuanYu1;
                kArray[3][1] = mShiBing2;
                kArray[4][1] = mShiBing3;
                kArray[2][2] = mGuanYu2;
                kArray[3][2] = mNull1;
                kArray[4][2] = mNull2;
                kArray[0][3] = fourGeneral.get(2);
                kArray[1][3] = findGeneral.get(fourGeneral.get(2).getType());
                kArray[2][3] = mShiBing4;
                kArray[3][3] = fourGeneral.get(3);
                kArray[4][3] = findGeneral.get(fourGeneral.get(3).getType());
                break;
            case 2:// 将拥曹营
                levelName.put(level, mContext.getResources().getString(R.string.level2));
                kArray[0][0] = mNull1;
                kArray[1][0] = fourGeneral.get(0);
                kArray[2][0] = findGeneral.get(fourGeneral.get(0).getType());
                kArray[3][0] = mShiBing1;
                kArray[4][0] = mGuanYu1;
                kArray[2][1] = fourGeneral.get(1);
                kArray[3][1] = findGeneral.get(fourGeneral.get(1).getType());
                kArray[4][1] = mGuanYu2;
                kArray[2][2] = fourGeneral.get(2);
                kArray[3][2] = findGeneral.get(fourGeneral.get(2).getType());
                kArray[4][2] = mShiBing2;
                kArray[0][3] = fourGeneral.get(3);
                kArray[1][3] = findGeneral.get(fourGeneral.get(3).getType());
                kArray[2][3] = mNull2;
                kArray[3][3] = mShiBing3;
                kArray[4][3] = mShiBing4;
                break;
            case 3://齐头并进
                levelName.put(level, mContext.getResources().getString(R.string.level3));
                kArray[0][0] = fourGeneral.get(0);
                kArray[1][0] = findGeneral.get(fourGeneral.get(0).getType());
                kArray[2][0] = mShiBing1;
                kArray[3][0] = fourGeneral.get(1);
                kArray[4][0] = findGeneral.get(fourGeneral.get(1).getType());
                kArray[2][1] = mShiBing2;
                kArray[3][1] = mNull1;
                kArray[4][1] = mGuanYu1;
                kArray[2][2] = mShiBing3;
                kArray[3][2] = mNull2;
                kArray[4][2] = mGuanYu2;
                kArray[0][3] = fourGeneral.get(2);
                kArray[1][3] = findGeneral.get(fourGeneral.get(2).getType());
                kArray[2][3] = mShiBing4;
                kArray[3][3] = fourGeneral.get(3);
                kArray[4][3] = findGeneral.get(fourGeneral.get(3).getType());
                break;
            case 4://兵分三路
                levelName.put(level, mContext.getResources().getString(R.string.level4));
                kArray[0][0] = mShiBing1;
                kArray[1][0] = fourGeneral.get(0);
                kArray[2][0] = findGeneral.get(fourGeneral.get(0).getType());
                kArray[3][0] = fourGeneral.get(1);
                kArray[4][0] = findGeneral.get(fourGeneral.get(1).getType());
                kArray[2][1] = mGuanYu1;
                kArray[3][1] = mNull1;
                kArray[4][1] = mShiBing2;
                kArray[2][2] = mGuanYu2;
                kArray[3][2] = mShiBing3;
                kArray[4][2] = mNull2;
                kArray[0][3] = mShiBing4;
                kArray[1][3] = fourGeneral.get(2);
                kArray[2][3] = findGeneral.get(fourGeneral.get(2).getType());
                kArray[3][3] = fourGeneral.get(3);
                kArray[4][3] = findGeneral.get(fourGeneral.get(3).getType());
                break;
            case 5://雨声淅沥
                levelName.put(level, mContext.getResources().getString(R.string.level5));
                kArray[0][0] = fourGeneral.get(0);
                kArray[1][0] = findGeneral.get(fourGeneral.get(0).getType());
                kArray[2][0] = fourGeneral.get(1);
                kArray[3][0] = findGeneral.get(fourGeneral.get(1).getType());
                kArray[4][0] = mShiBing1;
                kArray[2][1] = mGuanYu1;
                kArray[3][1] = mNull1;
                kArray[4][1] = mNull2;
                kArray[2][2] = mGuanYu2;
                kArray[3][2] = fourGeneral.get(2);
                kArray[4][2] = findGeneral.get(fourGeneral.get(2).getType());
                kArray[0][3] = mShiBing2;
                kArray[1][3] = mShiBing3;
                kArray[2][3] = fourGeneral.get(3);
                kArray[3][3] = findGeneral.get(fourGeneral.get(3).getType());
                kArray[4][3] = mShiBing4;
                break;
            case 6://左右布兵
                levelName.put(level, mContext.getResources().getString(R.string.level6));
                kArray[0][0] = mShiBing1;
                kArray[1][0] = mShiBing2;
                kArray[2][0] = fourGeneral.get(0);
                kArray[3][0] = findGeneral.get(fourGeneral.get(0).getType());
                kArray[4][0] = mNull1;
                kArray[2][1] = fourGeneral.get(1);
                kArray[3][1] = findGeneral.get(fourGeneral.get(1).getType());
                kArray[4][1] = mNull2;
                kArray[2][2] = fourGeneral.get(2);
                kArray[3][2] = findGeneral.get(fourGeneral.get(2).getType());
                kArray[4][2] = mGuanYu1;
                kArray[0][3] = mShiBing3;
                kArray[1][3] = mShiBing4;
                kArray[2][3] = fourGeneral.get(3);
                kArray[3][3] = findGeneral.get(fourGeneral.get(3).getType());
                kArray[4][3] = mGuanYu2;
                break;
            case 7://桃花园中
                levelName.put(level, mContext.getResources().getString(R.string.level7));
                kArray[0][0] = mShiBing1;
                kArray[1][0] = fourGeneral.get(0);
                kArray[2][0] = findGeneral.get(fourGeneral.get(0).getType());
                kArray[3][0] = mShiBing2;
                kArray[4][0] = mGuanYu1;
                kArray[2][1] = fourGeneral.get(1);
                kArray[3][1] = findGeneral.get(fourGeneral.get(1).getType());
                kArray[4][1] = mGuanYu2;
                kArray[2][2] = fourGeneral.get(2);
                kArray[3][2] = findGeneral.get(fourGeneral.get(2).getType());
                kArray[4][2] = mNull1;
                kArray[0][3] = mShiBing3;
                kArray[1][3] = fourGeneral.get(3);
                kArray[2][3] = findGeneral.get(fourGeneral.get(3).getType());
                kArray[3][3] = mShiBing4;
                kArray[4][3] = mNull2;
                break;
            case 8://一路进军
                levelName.put(level, mContext.getResources().getString(R.string.level8));
                kArray[0][0] = fourGeneral.get(0);
                kArray[1][0] = findGeneral.get(fourGeneral.get(0).getType());
                kArray[2][0] = fourGeneral.get(1);
                kArray[3][0] = findGeneral.get(fourGeneral.get(1).getType());
                kArray[4][0] = mGuanYu1;
                kArray[2][1] = fourGeneral.get(2);
                kArray[3][1] = findGeneral.get(fourGeneral.get(2).getType());
                kArray[4][1] = mGuanYu2;
                kArray[2][2] = fourGeneral.get(3);
                kArray[3][2] = findGeneral.get(fourGeneral.get(3).getType());
                kArray[4][2] = mNull1;
                kArray[0][3] = mShiBing1;
                kArray[1][3] = mShiBing2;
                kArray[2][3] = mShiBing3;
                kArray[3][3] = mShiBing4;
                kArray[4][3] = mNull2;
                break;
            case 9://一路顺风
                levelName.put(level, mContext.getResources().getString(R.string.level9));
                kArray[0][0] = fourGeneral.get(0);
                kArray[1][0] = findGeneral.get(fourGeneral.get(0).getType());
                kArray[2][0] = fourGeneral.get(1);
                kArray[3][0] = findGeneral.get(fourGeneral.get(1).getType());
                kArray[4][0] = mNull1;
                kArray[2][1] = mGuanYu1;
                kArray[3][1] = mShiBing1;
                kArray[4][1] = mShiBing2;
                kArray[2][2] = mGuanYu2;
                kArray[3][2] = fourGeneral.get(2);
                kArray[4][2] = findGeneral.get(fourGeneral.get(2).getType());
                kArray[0][3] = mShiBing3;
                kArray[1][3] = mShiBing4;
                kArray[2][3] = mNull2;
                kArray[3][3] = fourGeneral.get(3);
                kArray[4][3] = findGeneral.get(fourGeneral.get(3).getType());
                break;
            case 10://围而不歼
                levelName.put(level, mContext.getResources().getString(R.string.level10));
                kArray[0][0] = fourGeneral.get(0);
                kArray[1][0] = findGeneral.get(fourGeneral.get(0).getType());
                kArray[2][0] = mNull1;
                kArray[3][0] = fourGeneral.get(1);
                kArray[4][0] = findGeneral.get(fourGeneral.get(1).getType());
                kArray[2][1] = mGuanYu1;
                kArray[3][1] = fourGeneral.get(2);
                kArray[4][1] = findGeneral.get(fourGeneral.get(2).getType());
                kArray[2][2] = mGuanYu2;
                kArray[3][2] = fourGeneral.get(3);
                kArray[4][2] = findGeneral.get(fourGeneral.get(3).getType());
                kArray[0][3] = mShiBing1;
                kArray[1][3] = mShiBing2;
                kArray[2][3] = mShiBing3;
                kArray[3][3] = mShiBing4;
                kArray[4][3] = mNull2;
                break;
            case 11://捷足先登
                levelName.put(level, mContext.getResources().getString(R.string.level11));
                kArray[0][0] = mShiBing1;
                kArray[1][0] = mShiBing2;
                kArray[2][0] = mNull1;
                kArray[3][0] = fourGeneral.get(0);
                kArray[4][0] = findGeneral.get(fourGeneral.get(0).getType());
                kArray[2][1] = mNull2;
                kArray[3][1] = fourGeneral.get(1);
                kArray[4][1] = findGeneral.get(fourGeneral.get(1).getType());
                kArray[2][2] = mGuanYu1;
                kArray[3][2] = fourGeneral.get(2);
                kArray[4][2] = findGeneral.get(fourGeneral.get(2).getType());
                kArray[0][3] = mShiBing3;
                kArray[1][3] = mShiBing4;
                kArray[2][3] = mGuanYu2;
                kArray[3][3] = fourGeneral.get(3);
                kArray[4][3] = findGeneral.get(fourGeneral.get(3).getType());
                break;
        }
        return kArray;
    }

}
