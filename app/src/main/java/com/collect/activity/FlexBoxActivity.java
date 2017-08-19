//package com.collect.activity;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//
//import com.collect.R;
//import com.collect.adapter.ImageAdapter;
//import com.collect.base.BaseActivity;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import cn.campusapp.router.annotation.RouterMap;
//
///**
// * Created by zhangyuncai on 2017/8/15.
// */
//@RouterMap("activity://flexbox")
//public class FlexBoxActivity extends BaseActivity {
//    @BindView(R.id.recyclerview)
//    RecyclerView mRecyclerView;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_flexbox);
//        ButterKnife.bind(this);
//
////        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this);
////        flexboxLayoutManager.setFlexWrap(FlexWrap.WRAP);
////        flexboxLayoutManager.setFlexDirection(FlexDirection.ROW);
////        flexboxLayoutManager.setAlignItems(AlignItems.STRETCH);
//
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//
//
//        mRecyclerView.setLayoutManager(linearLayoutManager);
//        mRecyclerView.setAdapter(new ImageAdapter(this));
//
//
//    }
//}
