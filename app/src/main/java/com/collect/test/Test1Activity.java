package com.collect.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.collect.R;
import com.collect.base.BaseActivity;
import com.utils.ImageLoadUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/8/2.
 * 测试界面1
 */
@RouterMap({"activity://test1"})
public class Test1Activity extends BaseActivity {
    @BindView(R.id.iv_img)
    ImageView iv_img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        ButterKnife.bind(this);


        String imgUri="http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=false&word=%E7%BE%8E%E5%A5%B3%E5%9B%BE%E7%89%87&step_word=&hs=2&pn=10&spn=0&di=92885262690&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=1380084653%2C2448555822&os=2973510374%2C1623682744&simid=4142519358%2C676911946&adpicid=0&lpn=0&ln=3934&fr=&fmq=1501838974504_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=girl&bdtype=0&oriquery=&objurl=http%3A%2F%2Fwww.zhlzw.com%2FUploadFiles%2FArticle_UploadFiles%2F201204%2F20120412123914329.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bziszo_z%26e3Bv54AzdH3Ff3AzdH3F5s44AzdH3F0088d0_z%26e3Bip4s&gsm=&rpstart=0&rpnum=0";
        ImageLoadUtils.displayImage1(imgUri,iv_img,null);

    }
}
