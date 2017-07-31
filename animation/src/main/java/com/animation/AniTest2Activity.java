package com.animation;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by zhangyuncai on 2017/7/31.
 */

public class AniTest2Activity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        在跳转时就要注意一点，intent后面还要再传一个参数bundle，固定写法ActivityOptions.makeSceneTransitionAnimation(this).toBundle()，下一个Activity根据这个就能识别出使用5.0新转场动画。
        跳转的Activity在onCreate方法中，调用getWindow().setEnterTransition(new Explode());即可，注意要在setContentView之前哦。
         */
        /*
        TODO Explode的效果是下一个页面的元素从四面八方进入，最终形成完整的页面
         */
//        getWindow().setEnterTransition(new Explode());
        /*
        TODO Slide就是下一个页面元素从底部依次向上运动，最终形成完整的页面
         */
//        getWindow().setEnterTransition(new Slide());

        /*
        TODO Fade就是下一个页面元素渐变出现，最终形成完整的页面
        同样，就是跳转的Activity在onCreate方法中设置transition为Fade即可，只不过这里要最好要同时设置Enter和Exit。
         */
//        getWindow().setEnterTransition(new Fade());
//        getWindow().setExitTransition(new Fade());
        /*
        TODO Share Share是最复杂的一种转场方式，在跳转的两个Activity之间，如果有相同的View元素，那么，两个元素就可以设置成共享状态，在跳转时，这个View就会从第一个Activity的显示状态过渡到第二个Activity的显示状态，给用户的感觉仿佛是两个Activity共享一个View。
         */
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_anitest2);
    }
}
