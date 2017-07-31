package com.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Path;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by zhangyuncai on 2017/7/31.
 * 学习Tween动画 属性动画 帧动画
 * 前面一篇文章已经讲了Android中大部分的动画框架，回顾一下有：Tween动画，属性动画，帧动画，CircularReveal，
 * Activity转场动画，5.0新转场动画，Interpolator插值器，5.0转场动画分为Explode、Slide、Fade、Share四种模式
 */

public class AnimationActivity extends AppCompatActivity {

    private Button tween1, tween2, tween3, tween4, tween5, tween6, tween7, tween8, tween9;
    private ImageView iv_tween1, iv_tween2, iv_tween4, iv_tween5, iv_tween6, iv_tween7;
    private TextView tv_tween3;
    private View1 view1_tween5;

    private AnimationActivity activity;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        activity = this;

        tween1();

        tween2();

        tween3();

        tween4();

        tween5();

        tween6();

        tween7();

        tween8();

        tween9();

    }

    /**
     * TODO Android5.0新转场动画
     */
    private void tween9() {
        tween9 = (Button) findViewById(R.id.tween9);
        final ImageView iv_tween6 = (ImageView) findViewById(R.id.iv_tween6);

        tween9.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                /*
                在跳转时就要注意一点，intent后面还要再传一个参数bundle，固定写法ActivityOptions.makeSceneTransitionAnimation(this).toBundle()，下一个Activity根据这个就能识别出使用5.0新转场动画。
                跳转的Activity在onCreate方法中，调用getWindow().setEnterTransition(new Explode());即可，注意要在setContentView之前哦。

                 */
                Intent intent = new Intent(AnimationActivity.this, AniTest2Activity.class);
//                AnimationActivity.this.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());

                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity,
                        iv_tween6, "fab").toBundle());

            }
        });
    }

    /**
     * TODO 传统转场动画
     */
    private void tween8() {
        tween8 = (Button) findViewById(R.id.tween8);

        tween8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AnimationActivity.this, AniTestActivity.class));
                overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void tween7() {
        tween7 = (Button) findViewById(R.id.tween7);
        iv_tween7 = (ImageView) findViewById(R.id.iv_tween7);


        tween7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                View，中心点坐标，开始半径，结束半径
                 */
                final Animator anim = ViewAnimationUtils.createCircularReveal(iv_tween7, iv_tween7.getWidth() / 2, iv_tween7.getHeight() / 2, iv_tween7.getWidth(), 0);
                anim.setDuration(2000);
                anim.start();
            }
        });

    }

    /**
     * 可以看出来帧动画的使用还是比较简单的，但是缺点也很明显，就是动画不连续。如果要想动画连续也简单，就把图片做的多
     * 一点，每张图片只渐变一点点。但是这样随之而来的另一个问题就是图片太多，体积太大。所以也只能在图片流畅度和图片数
     * 量体积之间做一个平衡。这点比较尴尬。但是一般来说用来做一个动画的小Logo还是够用的
     */
    private void tween6() {
        tween6 = (Button) findViewById(R.id.tween6);
        iv_tween6 = (ImageView) findViewById(R.id.iv_tween6);

        iv_tween6.setImageResource(R.drawable.zhendonghua);
        final AnimationDrawable animationDrawable = (AnimationDrawable) iv_tween6.getDrawable();

        tween6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.start();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void tween5() {
        tween5 = (Button) findViewById(R.id.tween5);
        iv_tween5 = (ImageView) findViewById(R.id.iv_tween5);
        view1_tween5 = (View1) findViewById(R.id.view1_tween5);

        Path path = new Path();
//        path.addCircle(300, 300, 200, Path.Direction.CCW);

        path.lineTo(500, 500);

        /*
        ObjectAnimator.ofFloat方法的重载，传四个参数，第一个是做动画的控件，第二和第三个是动画的方向，
        第四个就是动画的Path路径，就是这么简单，剩下的就是构建Path了，Path的构建你可以随心所欲。你能构建出多
        酷炫的Path，它就能展示多酷炫的动画。
         */
        final ObjectAnimator animator = ObjectAnimator.ofFloat(iv_tween5, View.X, View.Y, path);
        animator.setDuration(2000);
        animator.setRepeatCount(1);
        animator.setRepeatMode(ValueAnimator.REVERSE);


        tween5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator.start();
            }
        });


    }

    /**
     * TODO ObjectAnimator
     * 可能你已经注意到了，ValueAnimator是属性动画底层的数值发生器，虽然拓展性很强，但是用它来写动画实在是麻烦，
     * 这一点Google当然也想到了，于是ObjectAnimator就诞生了，它把ValueAnimator封装在里面，我们用它可以简单地
     * 实现对控件的动画。代码如下
     */
    private void tween4() {
        tween4 = (Button) findViewById(R.id.tween4);
        iv_tween4 = (ImageView) findViewById(R.id.iv_tween4);

        /*
        第一行代码有三个参数，分别是做动画的控件, 需要动画的属性名，第三个是可变参数，表示动画值的范围。其中属性名
        是一个字符串，ObjectAnimator会根据这个属性名拼一个set[属性名]（setRotationY）方法，然后用反射调用，从而实现动画。
         */
        final ObjectAnimator animator = ObjectAnimator.ofFloat(iv_tween4, "rotationY", 0, 359);
        animator.setDuration(1000);
        animator.setRepeatCount(1);
        animator.setRepeatMode(ValueAnimator.REVERSE);


        tween4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator.start();
            }
        });
    }

    /**
     * TODO ValueAnimator
     */
    private void tween3() {
        tween3 = (Button) findViewById(R.id.tween3);
        tv_tween3 = (TextView) findViewById(R.id.tv_tween3);

        final ValueAnimator animator = ValueAnimator.ofFloat(0, 2000);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
                tv_tween3.setText(String.valueOf(value));
            }
        });

        tween3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator.start();
            }
        });

    }

    /**
     * TODO ValueAnimator
     * ValueAnimator：数值发生器，这是属性动画的根本，ValueAnimator的功能就是在两个数值范围内，顺
     * 序地产生过渡数值，过渡速率可以通过Intepolator来控制，过渡时间通过duration来设置，最终产生一
     * 组有特定变化速率的数值序列。那这个数值序列产生了干嘛呢？你想干嘛就干嘛。
     */
    private void tween2() {
        tween2 = (Button) findViewById(R.id.tween2);
        iv_tween2 = (ImageView) findViewById(R.id.iv_tween2);

        final ValueAnimator animator = ValueAnimator.ofFloat(0, 360);
        animator.setDuration(1000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setRepeatCount(1);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
                iv_tween2.setRotationY(value);
            }
        });
        animator.start();

        tween2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator.start();
            }
        });

    }

    private void tween1() {
        tween1 = (Button) findViewById(R.id.tween1);
        iv_tween1 = (ImageView) findViewById(R.id.iv_tween1);

        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.tween1);

        /*
        Tween动画使用起来简单，效果也比较流畅，但是缺点也是很明显，首先就是拓展性太差，只能写移动、缩放、
        旋转、渐变四种动画，以及这四种动画的组合，不支持自定义View的拓展。其次一个致命的缺点就是动画只是屏
        幕绘制上的动画，控件的属性并没有改变，一个经典的问题就是一个Button从一个地方移动到另一个地方，点击
        事件还是在原来的地方。所以Tween动画我们现在也基本放弃了，所有使用Tween动画的场景都可以用属性动画来替代

         */
        tween1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_tween1.startAnimation(animation);
            }
        });

    }
}
