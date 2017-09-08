package com.collect.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.collect.R;
import com.collect.base.BaseActivity;
import com.collect.fragment.TestFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/8/11.
 */
@RouterMap({"activity://test2"})
public class Test2Activity extends BaseActivity {


    @BindView(R.id.vp_test2)
    ViewPager mViewPager;
    @BindView(R.id.tv_title_test2)
    TextView tv_title_test2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        ButterKnife.bind(this);

        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        tv_title_test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(-1);
            }
        });

    }

    class MyPagerAdapter extends FragmentPagerAdapter {


        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return TestFragment.newInstance();
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
