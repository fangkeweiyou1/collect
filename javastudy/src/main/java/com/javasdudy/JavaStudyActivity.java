package com.javasdudy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.utils.FileUtil;

/**
 * Created by zhangyuncai on 2017/7/31.
 */

public class JavaStudyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javastudy);
//        Calendar calendar=Calendar.getInstance();
//        calendar.get(Calendar.DAY_OF_MONTH);

//        double ceil = Math.ceil(12.45);//返回大于该值得最小整数
//        System.out.println("-----------------<<<>>>--------------------ceil="+ceil);
//        double floor = Math.floor(12.45);//返回小于该值得最大整数
//        System.out.println("-----------------<<<>>>--------------------floor="+floor);

//        int round = Math.round(12.45f);//四舍五入
//        System.out.println("-----------------<<<>>>--------------------round=" + round);

//        double pow = Math.pow(2, 3);//2的3次方
//        System.out.println("-----------------<<<>>>--------------------pow="+pow);

        try {
            String ttt = FileUtil.getFileDir(this, "ttt");
            if (!TextUtils.isEmpty(ttt)) {
                System.out.println("-----------------<<<>>>--------------------ttt=" + ttt);
            }
//            FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
//            fileWriter.write("这是测试");
//            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
