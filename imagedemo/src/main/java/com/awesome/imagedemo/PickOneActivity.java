package com.awesome.imagedemo;

import androidx.annotation.Nullable;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.awesome.imagedemo.pickpicture.BaseActivity;
import com.awesome.sdk.util.ShowLogUtil;

import static com.awesome.imagedemo.pickpicture.Constant.WRITE_EXTERNAL_CODE;
import static com.awesome.imagedemo.pickpicture.Constant.WRITE_EXTERNAL_PERMISSION;


/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/7 14:35
 * Description:选择相册文件
 */
public class PickOneActivity extends BaseActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_one);
        if (!hasPermission(WRITE_EXTERNAL_PERMISSION)) {
            requestPermission(WRITE_EXTERNAL_CODE, WRITE_EXTERNAL_PERMISSION);
        }
        imageView= findViewById(R.id.iv_album);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 查看手机相册
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,0x01);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0x01) {
            // 选择图片的uri
            Uri uri = data.getData();

            // 第一种方式，使用文件路径创建图片
            // 文件路径的列
            String[] filePathColumn={MediaStore.Images.Media.DATA};
            // 获取图片的游标
            Cursor cursor = getContentResolver().query(uri, filePathColumn, null, null, null);
            cursor.moveToFirst();
            // 获取列的指针
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            ShowLogUtil.info("columnIndex: "+columnIndex);
            // 根据指针获取图片路径
            String picturePath = cursor.getString(columnIndex);
            ShowLogUtil.info( "picturePath: "+picturePath);
            cursor.close();
            // 创建图片
            Bitmap bitmap = BitmapFactory.decodeFile(picturePath);
            imageView.setImageBitmap(bitmap);

//            // 第二种方式
//            Bitmap bitmap = null;
//            try {
//                // 使用流创建图片
//                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//            imageView.setImageBitmap(bitmap);

        }
    }
}