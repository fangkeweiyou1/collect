package com.module_a;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.servicelib.RouterInterHelper;

/**
 * Created by zhangyuncai on 2017/8/18.
 */
public class ATestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atest);

        findViewById(R.id.bt_skipa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RouterInterHelper.skipBTestActivity();
            }
        });


    }
}
