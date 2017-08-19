package com.customview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by zhangyuncai on 2017/7/29.
 */

public class CustomViewActivity extends AppCompatActivity {

    private TextView view1, view2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customview);

        view1 = (TextView) findViewById(R.id.skip_view1);
        view2 = (TextView) findViewById(R.id.skip_view2);

        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomViewActivity.this, View1Activity.class));
            }
        });
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(CustomViewActivity.this, View2Activity.class));
                startActivity(new Intent(CustomViewActivity.this, View3Activity.class));
            }
        });

//        view1.performClick();
        view2.performClick();
    }
}
