package com.computer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.servicelib.byreflect.BaseReflectModel;
import com.servicelib.byreflect.BaseReflectModelManager;
import com.servicelib.iservice.IMouseService;
import com.servicelib.proxy.MouseProxy;

/**
 * Created by zhangyuncai on 2017/9/6.
 */

public class ComputerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);

//        ComputerModel computerModel=new ComputerModel();

        try {
            BaseReflectModel baseReflectModel = BaseReflectModelManager.getBaseReflectModel("com.mouse.reflect.MouseModel");
            if (baseReflectModel != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        IMouseService iMouseService = (IMouseService) new MouseProxy().getServiceInterface();
        if (iMouseService != null) {
            Fragment fragment = iMouseService.initMouseFragment(this);
            if (fragment != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_computer, fragment)
                        .commit();
            }
        }

        try {
            Class<?> aClass = Class.forName("com.mouse.service.MouseModule");
            if (aClass != null) {
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
