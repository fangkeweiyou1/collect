package com.collect.test;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.collect.R;
import com.collect.adapter.TestAdpater;
import com.collect.base.BaseActivity;

import butterknife.ButterKnife;
import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/8/2.
 * 测试界面1
 */
@RouterMap({"activity://test1"})
public class Test1Activity extends BaseActivity implements TestAdpater.TestListener {


    private TestAdpater mAdpater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        ButterKnife.bind(this);
        mAdpater = new TestAdpater(this, null, this);



    }



    /**
     * 如果金额小数点后面全部为0,就去掉
     *
     * @return
     */
    public String getFaceValue(double faceValue) {
        if (Math.round(faceValue) - faceValue == 0) {
            return (int) faceValue + "";
        }
        return faceValue + "";
    }

    /**
     * ImageLoader 加载图片
     */
    private void imageLoaderImg() {
//        String imgUri = "http://www.zhlzw.com/UploadFiles/Article_UploadFiles/201204/20120412123914329.jpg";
//        ImageLoadUtils.displayImage1(imgUri,iv_img,null);
    }

    /**
     * Glide 加载图片
     */
    private void glideImg() {
//        String imgUri = "http://www.zhlzw.com/UploadFiles/Article_UploadFiles/201204/20120412123914329.jpg";
//        Glide.with(this)
//                .load(imgUri)
//                .centerCrop()
//                .into(iv_img);

    }

    @Override
    public void onClickItem(String content) {

    }

}
