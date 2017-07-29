package com.numberprogressbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.daimajia.numberprogressbar.OnProgressBarListener;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zhangyuncai on 2017/7/27.
 * 学习numberprogressbar的使用
 */

public class ShowProgressActivity extends AppCompatActivity implements OnProgressBarListener {
    private Timer timer;

    private NumberProgressBar bnp;
    private int i = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showprogress);

        bnp = (NumberProgressBar) findViewById(R.id.numberbar1);
        bnp.setOnProgressBarListener(this);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        bnp.incrementProgressBy(1);
                        i++;
                        if (i == 100) {
                            timer.cancel();
                        }
                    }
                });
            }
        }, 1000, 100);


    }

    @Override
    public void onProgressChange(int current, int max) {
        if (current == max) {
            Toast.makeText(getApplicationContext(), "结束啦", Toast.LENGTH_SHORT).show();
            bnp.setProgress(0);
        }
    }
}
