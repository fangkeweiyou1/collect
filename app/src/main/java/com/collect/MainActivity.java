package com.collect;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.collect.adapter.TestAdpater;
import com.collect.base.BaseActivity;
import com.collect.model.TestModel;
import com.collect.test.Test1Activity;
import com.collect.test.Test2Activity;
import com.collect.test.Test3Activity;
import com.collect.test.Test4Activity;
import com.collect.test.Test5Activity;
import com.collect.test.Test6Activity;
import com.collect.test.Test7Activity;
import com.umeng.analytics.MobclickAgent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.campusapp.router.Router;
import timber.log.Timber;

public class MainActivity extends BaseActivity implements TestAdpater.TestListener {
    public static final String TAG = "MainActivity";

    @BindView(R.id.tv_titlename)
    TextView tvTitlename;
    @BindView(R.id.et_input)
    EditText etInput;
    @BindView(R.id.skip)
    TextView skip;
    @BindView(R.id.cv_custom)
    CardView cvCustom;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    private TestAdpater mAdpater;

    private Map<String, String> activityNameMap = new LinkedHashMap<>();//LinkedHashMap可以对KEY值顺序取出(这个是打开APP中的Activity)
    private Map<String, String> actionActivityNameMap = new LinkedHashMap<>();//LinkedHashMap可以对KEY值顺序取出(这个是打开module中的Activity)
    private boolean isAuto = true;//是否自动跳转
    private File file;
    private static String fileName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



//        getPermissions();
//
//        try {
//            Class<?> clazz = Class.forName("com.collect.model.TestModel");
//            Constructor constructor = clazz.getDeclaredConstructor(new Class[]{});
//            Object o = constructor.newInstance();
//            if (o instanceof TestModel) {
//                TestModel testModel = (TestModel) o;
//                testModel.setDesc("我是明天你好");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        initView();

        addActivityNames();

        addTestModel();

        initEvent();

        if (isAuto) {
            autoSkip();
        }

    }

    /**
     * 获取权限
     * 暂时不要注释掉,开发阶段,我需要刚装上APP,获取其中的通讯录权限
     */
    private void getPermissions() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList<String> list = new ArrayList<>();
            list.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            list.add(Manifest.permission.ACCESS_FINE_LOCATION);
            list.add(Manifest.permission.READ_LOGS);
            list.add(Manifest.permission.READ_PHONE_STATE);
            list.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            list.add(Manifest.permission.SET_DEBUG_APP);
            list.add(Manifest.permission.SYSTEM_ALERT_WINDOW);
            list.add(Manifest.permission.GET_ACCOUNTS);
            list.add(Manifest.permission.WRITE_APN_SETTINGS);
            list.add(Manifest.permission.CALL_PHONE);
            list.add(Manifest.permission.READ_CONTACTS);
            list.add(Manifest.permission.CAMERA);

            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                String permission = iterator.next();
                if (ContextCompat.checkSelfPermission(this, permission) >= 0) {
                    Timber.d("----------->>>>>>>>-----------已经获取权限" + permission);
                    iterator.remove();
                }
            }

            if (list.size() != 0) {
                String[] mPermissionList = new String[list.size()];
                list.toArray(mPermissionList);
                ActivityCompat.requestPermissions(this, mPermissionList, 123);
            }

        }
    }

    private void autoSkip() {
//        startActivity(new Intent(this,Kotlin01Activity.class));
//        startActivity(new Intent(this, ScrollViewActivity.class));
//        startActivity(new Intent(this, ExceptionActivity.class));
//        startActivity(new Intent(this, DialogBasicActvitity.class));
//        startActivity(new Intent(this,TextUtilActivity.class));
//        startActivity(new Intent(this,ConstraintLayoutActivity.class));
//        startActivity(new Intent(this,Test1Activity.class));
//        startActivity(new Intent(this,ProgressbarBasicActivity.class));
//        startActivity(new Intent(this,DialogBasicActvitity.class));
//        startActivity(new Intent(this,AnimationActivity.class));
//        startActivity(new Intent(this,TextViewActivity.class));
//        String params = "activity://regex";
//        Router.open(params);

//        getLocalHost();

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                openActivityForReceiver("customview");
//                openActivityForReceiver("animation");
//                openActivityForReceiver("javastudy");
//                openActivityForReceiver("calendarshow");
//                openActivityForReceiver("zhihu");
//                findRouterParams("rxjava");
//                findRouterParams("keyboard");
//                findRouterParams("timer");
//                findRouterParams("annotations");
//                findRouterParams("kuaijiejian");
//                findRouterParams("lottie");
//                findRouterParams("test1");
//                findRouterParams("test2");
//                findRouterParams("test3");
                findRouterParams("test4");
//                findRouterParams("test5");
//                findRouterParams("test6");
//                findRouterParams("test7");
//                findRouterParams("joda");
//                findRouterParams("piker");
//                findRouterParams("piker2");
//                findRouterParams("pickerview3");
//                findRouterParams("pickerview4");
//                findRouterParams("pickerview5");
//                findRouterParams("search");
//                findRouterParams("mychart");
//                findRouterParams("view");
//                findRouterParams("file");
//                findRouterParams("service");
//                findRouterParams("dagger2");
//                findRouterParams("http");
//                findRouterParams("coordinator");
//                findRouterParams("recycleranimator");
//                findRouterParams("coordinator2");
//                findRouterParams("flexbox");
//                findRouterParams("updateapp");
//                findRouterParams("atest");
            }
        }, 200);

    }

    private void getLocalHost() {
        try {
//            InetAddress localHost = InetAddress.getLocalHost();
            InetAddress inetAddress = InetAddress.getLocalHost();
            byte[] address = inetAddress.getAddress();
            String canonicalHostName = inetAddress.getCanonicalHostName();
            String hostAddress = inetAddress.getHostAddress();
            String hostName = inetAddress.getHostName();

            for (byte addres : address) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Handler mHandler = new Handler() {

    };

    private boolean findRouterParams(String activityName) {
//        if (TextUtils.equals("atest", activityName)) {
//            RouterInterHelper.skipATestActivity();
//        }


//        if (TextUtils.equals("kotlin01", activityName)) {
//            LogUtils.i(TAG, "kotlin01");
//            startActivity(new Intent(this, Kotlin01Activity.class));
//            return true;
//        }

        if (actionActivityNameMap.containsKey(activityName)) {
            openActivityForReceiver(activityName);
            return true;
        }


        if (activityNameMap.containsKey(activityName)) {
            if (!TextUtils.isEmpty(activityName)) {
                String params = String.format("activity://%s", activityName);
                System.out.println("-----------------<<<>>>--------------------" + "跳转参数=" + params);
                Router.open(params);
            }
        }


        return false;
    }

    private void openActivityForReceiver(String activityName) {
        if (!actionActivityNameMap.containsKey(activityName)) {
            return;
        }


        Intent intent = new Intent();
        intent.setAction(actionActivityNameMap.get(activityName));
        sendBroadcast(intent);
    }

    private void addActivityNames() {
//        activityNameMap.put("banner", "BannerActivity");
//        actionActivityNameMap.put("banner", "open_banneractivity");

//        actionActivityNameMap.put("numberprogressbar", "open_showprogressactivity");//多彩进度条


        //TODO 学习自定义view
        actionActivityNameMap.put("customview", "open_customviewactivity");//自定义view模块

        //TODO 学习animation
        actionActivityNameMap.put("animation", "open_animationactivity");//animation模块

        //TODO 学习javastudy
        actionActivityNameMap.put("javastudy", "open_javastudy");//javastudy模块

        //TODO 制作日历
        actionActivityNameMap.put("calendarshow", "open_calendarshowactivity");//日历模块

        //TODO 学习知乎选择相册
        actionActivityNameMap.put("zhihu", "open_zhihuactivity");//知乎模块


//        activityNameMap.put("musicplayer", "MusicPlayerActivity");
//        actionActivityNameMap.put("musicplayer", "open_musicplayeractivity");

//        activityNameMap.put("special", "SpecialActivity");
//        actionActivityNameMap.put("special", "open_specialactivity");

//        activityNameMap.put("kotlin01", Kotlin01Activity.class.getSimpleName());

//        activityNameMap.put("textutil", TextUtilActivity.class.getSimpleName());
//        activityNameMap.put("contraintlayout", ConstraintLayoutActivity.class.getSimpleName());

        //TODO:学习java
//        activityNameMap.put("studyjava", StudyJavaActivity.class.getSimpleName());
//        activityNameMap.put("sharepre", SharepreActivity.class.getSimpleName());
//        activityNameMap.put("picker", PickerActivity.class.getSimpleName());

        //TODO:学习异常
//        activityNameMap.put("exception", ExceptionActivity.class.getSimpleName());
//        activityNameMap.put("meterialdesign", MeterialDesignActivity.class.getSimpleName());
        activityNameMap.put("test1", Test1Activity.class.getSimpleName());
        activityNameMap.put("test2", Test2Activity.class.getSimpleName());
        activityNameMap.put("test3", Test3Activity.class.getSimpleName());
        activityNameMap.put("test4", Test4Activity.class.getSimpleName());
        activityNameMap.put("test5", Test5Activity.class.getSimpleName());
        activityNameMap.put("test6", Test6Activity.class.getSimpleName());
        activityNameMap.put("test7", Test7Activity.class.getSimpleName());
//        activityNameMap.put("test3", Test3Activity.class.getSimpleName());
//        activityNameMap.put("test3", Test3Activity.class.getSimpleName());
//        activityNameMap.put("test4", Test4Activity.class.getSimpleName());
//        activityNameMap.put("test5", Test5Activity.class.getSimpleName());
//        activityNameMap.put("test6", Test6Activity.class.getSimpleName());
        activityNameMap.put("mychart", "MyChartActivity");
//        activityNameMap.put("piker", "PikerActivity");
        activityNameMap.put("piker2", "Piker2Activity");
        activityNameMap.put("lottie", "LottieActivity");
        activityNameMap.put("recycleranimator", "LottieActivity");
//
//        activityNameMap.put("learnview", LearnViewActivity.class.getSimpleName());
//
//        activityNameMap.put("decorationrecyclerview", DecorationRecAct.class.getSimpleName());
//
//        activityNameMap.put("regex", RegexActivity.class.getSimpleName());
//
//        activityNameMap.put("flexbox", FlexboxActivity.class.getSimpleName());
//
//        activityNameMap.put("flexbox2", Flexbox2Activity.class.getSimpleName());
//
//        activityNameMap.put("dialogbasic", DialogBasicActvitity.class.getSimpleName());
//        activityNameMap.put("animation", AnimationActivity.class.getSimpleName());
//
//        activityNameMap.put("drawerlayout", DrawerLayoutActivity.class.getSimpleName());
//
//        activityNameMap.put("imageviewbasic", ImageViewBasicActivity.class.getSimpleName());
//
//        activityNameMap.put("linearlayoutbasic", LinearLayoutBasicActivity.class.getSimpleName());
//
//        activityNameMap.put("partrecycler", PartRecyclerActivity.class.getSimpleName());
//        activityNameMap.put("progressbarbasic", ProgressbarBasicActivity.class.getSimpleName());
//        activityNameMap.put("recyclerhome", RecyclerHomeActivity.class.getSimpleName());
//        activityNameMap.put("renativelayoutbasic", RenativeLayoutBasicActivity.class.getSimpleName());
//        activityNameMap.put("textviewbasic", TextViewActivity.class.getSimpleName());
//        activityNameMap.put("udlrrecycler", UDLRRecyclerActivity.class.getSimpleName());
//        activityNameMap.put("viewpagerbasic", ViewpagerBasicActivity.class.getSimpleName());
//        activityNameMap.put("webviewbasic", WebviewBasicActivity.class.getSimpleName());
//        activityNameMap.put("tablayout", TabLayoutActivity.class.getSimpleName());
//        activityNameMap.put("comparator", ComparatorActivity.class.getSimpleName());
//        activityNameMap.put("math", MathActivity.class.getSimpleName());
//        activityNameMap.put("timer", TimerActivity.class.getSimpleName());
//        activityNameMap.put("annotations", AnnotationsActivity.class.getSimpleName());
//        activityNameMap.put("kuaijiejian", KuanjiejianActivity.class.getSimpleName());
//        activityNameMap.put("rxjava", "RxjavaActivity");
//        activityNameMap.put("atest", "ATestActivity");
//        activityNameMap.put("flexbox", "FlexBoxActivity");
        activityNameMap.put("view", "ViewActivity");
//        activityNameMap.put("file", "FileActivity");
//        activityNameMap.put("service", ServiceActivity.class.getSimpleName());
//        activityNameMap.put("dagger2", "DaggerActivity");
//        activityNameMap.put("http", "HttpActivity");
        activityNameMap.put("coordinator", "CoordinatorActivity");
//        activityNameMap.put("coordinator2", Coordinator2Activity.class.getSimpleName());
//        activityNameMap.put("updateapp", "UpdateAppActivity");
        activityNameMap.put("keyboard", "KeyBoardActivity");
        activityNameMap.put("joda", "JodaActivity");
        activityNameMap.put("pickerview3", "PickerView3Activity");
        activityNameMap.put("pickerview4", "PickerView4Activity");
        activityNameMap.put("pickerview5", "PickerView5Activity");
        activityNameMap.put("search", "SearchActivity");


    }

    private void addTestModel() {
        List<String> activityNames = new ArrayList<>(actionActivityNameMap.keySet());
        List<TestModel> list = new ArrayList<>();
        TestModel model;

        for (int i = 0; i < activityNames.size(); i++) {
            model = new TestModel();
            model.setName("activity名称" + i);
            model.setContent(activityNames.get(i));
            list.add(model);
        }

        activityNames = new ArrayList<>(activityNameMap.keySet());
        for (int i = 0; i < activityNames.size(); i++) {
            model = new TestModel();
            model.setName("activity名称" + i);
            model.setContent(activityNames.get(i));
            list.add(model);
        }

        mAdpater.setData(list);
    }

    private void initView() {
        mAdpater = new TestAdpater(this, this);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.setAdapter(mAdpater);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(dividerItemDecoration);

//        try {
//            file = new File(FileUtil.getDir(this), "/aaa.txt");
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            fileName = file.getAbsolutePath();
//            System.out.println("-----------------<<<>>>--------------------file==null:" + (file == null));
//        } catch (Exception e) {
//
//        }
//        String deviceInfo = getDeviceInfo(this);
//        System.out.println("-----------------<<<>>>--------------------deviceInfo=" + deviceInfo);
//
//        String macAddress = getMacAddress();
//        System.out.println("-----------------<<<>>>--------------------macAddress=" + macAddress);
    }

    private void initEvent() {
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MobclickAgent.onEvent(MainActivity.this, "skip");
                System.out.println("-----------------<<<>>>--------------------编辑界面名称并跳转");
            }
        });
    }

    //我是第329行

    @Override
    public void onClickItem(String content) {
        findRouterParams(content);
    }


    public static boolean checkPermission(Context context, String permission) {
        boolean result = false;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                Class<?> clazz = Class.forName("android.content.Context");
                Method method = clazz.getMethod("checkSelfPermission", String.class);
                int rest = (Integer) method.invoke(context, permission);
                if (rest == PackageManager.PERMISSION_GRANTED) {
                    result = true;
                } else {
                    result = false;
                }
            } catch (Exception e) {
                result = false;
            }
        } else {
            PackageManager pm = context.getPackageManager();
            if (pm.checkPermission(permission, context.getPackageName()) == PackageManager.PERMISSION_GRANTED) {
                result = true;
            }
        }
        return result;
    }

    public static String getDeviceInfo(Context context) {
        try {
            org.json.JSONObject json = new org.json.JSONObject();
            android.telephony.TelephonyManager tm = (android.telephony.TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            String device_id = null;
            if (checkPermission(context, Manifest.permission.READ_PHONE_STATE)) {
                device_id = tm.getDeviceId();
            }
            String mac = null;
            FileReader fstream = null;
            try {
                System.out.println("-----------------<<<>>>--------------------1");
                fstream = new FileReader("/sys/class/net/wlan0/address");
//                fstream = new FileReader(fileName);
            } catch (FileNotFoundException e) {
                System.out.println("-----------------<<<>>>--------------------2");
                fstream = new FileReader("/sys/class/net/eth0/address");
//                fstream = new FileReader(fileName);
            }
            BufferedReader in = null;
            if (fstream != null) {
                try {
                    System.out.println("-----------------<<<>>>--------------------3");
                    in = new BufferedReader(fstream, 1024);
                    mac = in.readLine();
                } catch (IOException e) {
                    System.out.println("-----------------<<<>>>--------------------4");
                } finally {
                    if (fstream != null) {
                        try {
                            System.out.println("-----------------<<<>>>--------------------5");
                            fstream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("-----------------<<<>>>--------------------6");
                        }
                    }
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            System.out.println("-----------------<<<>>>--------------------mac="+mac);

            json.put("mac", mac);
            if (TextUtils.isEmpty(device_id)) {
                device_id = mac;
                System.out.println("-----------------<<<>>>--------------------7");
            }
            if (TextUtils.isEmpty(device_id)) {
                device_id = android.provider.Settings.Secure.getString(context.getContentResolver(),
                        android.provider.Settings.Secure.ANDROID_ID);
                System.out.println("-----------------<<<>>>--------------------8");
            }
            json.put("device_id", device_id);
            return json.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getMacAddress(){
 /*获取mac地址有一点需要注意的就是android 6.0版本后，以下注释方法不再适用，不管任何手机都会返回"02:00:00:00:00:00"这个默认的mac地址，这是googel官方为了加强权限管理而禁用了getSYstemService(Context.WIFI_SERVICE)方法来获得mac地址。*/
        //        String macAddress= "";
//        WifiManager wifiManager = (WifiManager) MyApp.getContext().getSystemService(Context.WIFI_SERVICE);
//        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
//        macAddress = wifiInfo.getMacAddress();
//        return macAddress;

        String macAddress = null;
        StringBuffer buf = new StringBuffer();
        NetworkInterface networkInterface = null;
        try {
            networkInterface = NetworkInterface.getByName("eth1");
            if (networkInterface == null) {
                networkInterface = NetworkInterface.getByName("wlan0");
            }
            if (networkInterface == null) {
                return "02:00:00:00:00:02";
            }
            byte[] addr = networkInterface.getHardwareAddress();
            for (byte b : addr) {
                buf.append(String.format("%02X:", b));
            }
            if (buf.length() > 0) {
                buf.deleteCharAt(buf.length() - 1);
            }
            macAddress = buf.toString();
        } catch (SocketException e) {
            e.printStackTrace();
            return "02:00:00:00:00:02";
        }
        return macAddress;
    }
}
