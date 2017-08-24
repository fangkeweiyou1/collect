package com.collect.test;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.collect.R;
import com.collect.base.BaseActivity;

import java.util.HashMap;
import java.util.Map;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/8/16.
 */
@RouterMap("activity://test3")
public class Test3Activity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);

//        String[] strings = new String[]{"1", "2"};
//        List<String> strings1 = Arrays.asList(strings);
//        strings[0] = "3";
//        for (String s : strings1) {
//            System.out.println("-----------------<<<>>>--------------------s=" + s);
//        }

        Map<String,Integer> map=new HashMap<>();
        map.put(null,1);
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            System.out.println("-----------------<<<>>>--------------------key="+stringIntegerEntry.getKey());
            System.out.println("-----------------<<<>>>--------------------value="+stringIntegerEntry.getValue());
        }


    }
}


















//