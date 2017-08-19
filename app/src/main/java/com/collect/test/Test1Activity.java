package com.collect.test;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.collect.CollectApplication;
import com.collect.R;
import com.collect.adapter.TestAdpater;
import com.collect.base.BaseActivity;
import com.collect.component.DaggerTest1Component;
import com.collect.model.Test2Model;
import com.collect.module.Test1Module;

import javax.inject.Inject;

import butterknife.ButterKnife;
import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/8/2.
 * 测试界面1
 */
@RouterMap({"activity://test1"})
public class Test1Activity extends BaseActivity implements TestAdpater.TestListener {


    private TestAdpater mAdpater;
    @Inject
    Test2Model test2Model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        ButterKnife.bind(this);
        mAdpater = new TestAdpater(this, null, this);

        DaggerTest1Component
                .builder()
                .baseComponent(((CollectApplication) getApplication()).getBaseComponent())
                .test1Module(new Test1Module())
                .build()
                .inject(this);

//        if (test2Model != null) {
//            System.out.println("-----------------<<<>>>--------------------地址=" + test2Model);
//        }
//
//        String string = CollectApplication.getContext().getString(R.string.animation);
//        System.out.println("-----------------<<<>>>--------------------string=" + string);


//        String content = "";
//        int indexOf = content.indexOf("t");
//        System.out.println("-----------------<<<>>>--------------------indexOf=" + indexOf);


//        test(new Test(){
//            @Override
//            public void show() {
//                super.show();
//                System.out.println("-----------------<<<>>>--------------------show2");
//            }
//        });

//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        new TestHelper().addName(list);
//
//        for (String s : list) {
//            System.out.println("-----------------<<<>>>--------------------s=" + s);
//        }



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
