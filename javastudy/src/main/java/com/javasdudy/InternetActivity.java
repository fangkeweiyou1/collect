package com.javasdudy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.net.InetAddress;

/**
 * Created by zhangyuncai on 2017/8/8.
 */

public class InternetActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);

        getLocalHost();

    }

    private void getLocalHost() {
        try {
//            InetAddress localHost = InetAddress.getLocalHost();
            InetAddress inetAddress = InetAddress.getLocalHost();
            byte[] address = inetAddress.getAddress();
            String canonicalHostName = inetAddress.getCanonicalHostName();
            String hostAddress = inetAddress.getHostAddress();
            String hostName = inetAddress.getHostName();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
