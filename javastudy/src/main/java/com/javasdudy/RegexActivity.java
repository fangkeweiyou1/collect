package com.javasdudy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by zhangyuncai on 2017/8/11.
 */

public class RegexActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regex);

        test5();
    }

    private void test5() {
        String str = "dadf";
        String reg = "^\\D+$";
        boolean matches = str.matches(reg);
        System.out.println("-----------------<<<>>>--------------------boolean=" + matches);
    }

    /**
     * TODO \d表示数字 \D非数字
     */
    private void test4() {
        String str = "b9";
        String regex = "[bdc]\\d";//str的第一个 b|d|c,第二个是数字即可就是true,且只能一个
        boolean matches = str.matches(regex);
        System.out.println("-----------------<<<>>>--------------------matches=" + matches);
    }

    private void test3() {
        String str = "b";
        String regex = "[^bdc]";//str的第一个 b|d|c,非bdc即可就是true,且只能一个
        boolean matches = str.matches(regex);
        System.out.println("-----------------<<<>>>--------------------matches=" + matches);
    }

    private void test2() {
        String str = "bac";
        String regex = "[bdc][a-z]";//str的第一个 b|d|c,第二个只要是字母即可就是true,且只能一个
        boolean matches = str.matches(regex);
        System.out.println("-----------------<<<>>>--------------------matches=" + matches);
    }

    private void test1() {
        String str = "b";
        String regex = "[bdc]";//str是 b|d|c,就是true,且只能一个
        boolean matches = str.matches(regex);
        System.out.println("-----------------<<<>>>--------------------matches=" + matches);
    }
}
