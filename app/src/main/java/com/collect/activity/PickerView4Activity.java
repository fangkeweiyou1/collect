package com.collect.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.collect.R;
import com.collect.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/9/20.
 */
@RouterMap("activity://pickerview4")
public class PickerView4Activity extends BaseActivity {

    private OptionsPickerView optionsPickerView;
    private TextView tv_option;
    private List<String> yijiList;
    private List<List<String>> erjiList;
    private List<List<List<String>>> sanjiList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pickerview4);
        tv_option = (TextView) findViewById(R.id.tv_option);

        initData2();

        initView2();


        initEvent2();
    }

    @Override
    protected void initView2() {
        initOptionPickerView();
    }

    @Override
    protected void initData2() {

        yijiList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            yijiList.add("一级" + i);
        }


        erjiList = new ArrayList<>();
        List<String> erjiZiji;
        for (int i = 0; i < yijiList.size(); i++) {
            erjiZiji = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                erjiZiji.add(String.format("二级子集%d/%d", i, j));
            }
            erjiList.add(erjiZiji);
        }

        sanjiList = new ArrayList<>();
        List<List<String>> sanjiZiji;
        List<String> sanjiZijiZiji;
        for (int i = 0; i < yijiList.size(); i++) {
            sanjiZiji = new ArrayList<>();
            for (int j = 0; j < erjiList.size(); j++) {
                sanjiZijiZiji = new ArrayList<>();
                for (int k = 0; k < j + 1; k++) {
                    sanjiZijiZiji.add(String.format("三级子集子集%d/%d/%d", i, j, k));
                }
                sanjiZiji.add(sanjiZijiZiji);
            }
            sanjiList.add(sanjiZiji);
        }


    }

    @Override
    protected void initEvent2() {
        tv_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (optionsPickerView != null) {
                    optionsPickerView.show();
                }
            }
        });
    }

    private void initOptionPickerView() {
        OptionsPickerView.Builder builder = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {

            }
        });

        //如果没有设置数据,则只显示取消/确定按钮

        optionsPickerView = builder.build();

        optionsPickerView.setPicker(yijiList, erjiList, sanjiList);
    }
}
