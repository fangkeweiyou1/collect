package com.openimdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.mobileim.IYWLoginService;
import com.alibaba.mobileim.YWIMKit;
import com.alibaba.mobileim.YWLoginParam;
import com.alibaba.mobileim.channel.event.IWxCallback;
import com.alibaba.mobileim.utility.UserContext;

/**
 * Created by zhangyuncai on 2017/9/12.
 */

public class OpenimActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_openimdemo);

        String userid = "testpro54";
        String upasswordserId = "taobao1234";
        String appKey = "23015524";
        LoginSampleHelper.getInstance().initIMKit(userid, appKey);
        IYWLoginService loginService = LoginSampleHelper.getInstance().getIMKit().getLoginService();
        YWLoginParam loginParam = new YWLoginParam(userid, upasswordserId, appKey);
        loginService.login(loginParam, new IWxCallback() {
            @Override
            public void onSuccess(Object... objects) {
                System.out.println("-----------------<<<>>>--------------------成功");
                initView();
            }

            @Override
            public void onError(int i, String s) {

            }

            @Override
            public void onProgress(int i) {

            }
        });


    }

    private void initView() {

        Fragment fragment = null;
        YWIMKit mIMKit = LoginSampleHelper.getInstance().getIMKit();
        if (mIMKit != null) {
            Bundle fragmentBundle = new Bundle();
            fragmentBundle.putSerializable(UserContext.EXTRA_USER_CONTEXT_KEY, mIMKit.getUserContext());
            fragment = Fragment.instantiate(this, mIMKit.getConversationFragmentClass().getName(), fragmentBundle);
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_layout, fragment)
                .commit();
    }
}
