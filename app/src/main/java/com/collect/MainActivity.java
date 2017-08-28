package com.collect;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.collect.adapter.TestAdpater;
import com.collect.base.BaseActivity;
import com.collect.model.TestModel;
import com.collect.test.Test1Activity;
import com.collect.test.Test2Activity;
import com.collect.test.Test3Activity;
import com.utils.LogUtils;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.campusapp.router.Router;

public class MainActivity extends BaseActivity implements TestAdpater.TestListener {

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        initView();

        addActivityNames();

        addTestModel();

        initEvent();

        if (isAuto)
            autoSkip();

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
//                findRouterParams("test1");
//                findRouterParams("test2");
//                findRouterParams("test3");
//                findRouterParams("joda");
                findRouterParams("mychart");
//                findRouterParams("view");
//                findRouterParams("file");
//                findRouterParams("service");
//                findRouterParams("dagger2");
//                findRouterParams("http");
//                findRouterParams("coordinator");
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
                System.out.println("-----------------<<<>>>--------------------addres=" + addres);
            }
            System.out.println("-----------------<<<>>>--------------------canonicalHostName=" + canonicalHostName);
            System.out.println("-----------------<<<>>>--------------------hostAddress=" + hostAddress);
            System.out.println("-----------------<<<>>>--------------------hostName=" + hostName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Handler mHandler = new Handler() {

    };

    private boolean findRouterParams(String activityName) {
//        if (TextUtils.equals("atest", activityName)) {
//            System.out.println("-----------------<<<>>>--------------------使用中间件跳转");
//            RouterInterHelper.skipATestActivity();
//        }


//        if (TextUtils.equals("kotlin01", activityName)) {
//            LogUtils.i(TAG, "kotlin01");
//            startActivity(new Intent(this, Kotlin01Activity.class));
//            return true;
//        }

        System.out.println("-----------------<<<>>>--------------------1=" + activityName);
        if (actionActivityNameMap.containsKey(activityName)) {
            openActivityForReceiver(activityName);
            System.out.println("-----------------<<<>>>--------------------2");
            return true;
        }

        if (activityNameMap.containsKey(activityName)) {
            if (!TextUtils.isEmpty(activityName)) {
                System.out.println("-----------------<<<>>>--------------------paramsPart=" + activityName);
                String params = String.format("activity://%s", activityName);
                LogUtils.i(TAG, "跳转参数=" + params);
                Router.open(params);
            }
        }


        return false;
    }

    private void openActivityForReceiver(String activityName) {
        if (!actionActivityNameMap.containsKey(activityName)) {
            return;
        }

        System.out.println("-----------------<<<>>>--------------------发送广播信息=" + actionActivityNameMap.get(activityName));

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
//        activityNameMap.put("test3", Test3Activity.class.getSimpleName());
//        activityNameMap.put("test3", Test3Activity.class.getSimpleName());
//        activityNameMap.put("test4", Test4Activity.class.getSimpleName());
//        activityNameMap.put("test5", Test5Activity.class.getSimpleName());
//        activityNameMap.put("test6", Test6Activity.class.getSimpleName());
        activityNameMap.put("mychart", "MyChartActivity");
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
//        activityNameMap.put("coordinator", CoordinatorActivity.class.getSimpleName());
//        activityNameMap.put("coordinator2", Coordinator2Activity.class.getSimpleName());
//        activityNameMap.put("updateapp", "UpdateAppActivity");
        activityNameMap.put("keyboard", "KeyBoardActivity");
        activityNameMap.put("joda", "JodaActivity");


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

    }

    private void initEvent() {

    }

    //我是第329行

    @Override
    public void onClickItem(String content) {
        System.out.println("-----------------<<<>>>--------------------点击内容=" + content);
        findRouterParams(content);
    }
}
