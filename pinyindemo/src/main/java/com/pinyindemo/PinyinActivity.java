package com.pinyindemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.promeg.pinyinhelper.Pinyin;

/**
 * Created by zhangyuncai on 2017/9/3.
 */

public class PinyinActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinyin);

        String s = Pinyin.toPinyin('好');
        System.out.println("-----------------<<<>>>--------------------s=" + s);
    }
}
