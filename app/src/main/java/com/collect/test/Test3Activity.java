package com.collect.test;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.util.LruCache;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;

import com.collect.R;
import com.collect.adapter.Test3Adapter;
import com.collect.base.BaseActivity;
import com.utils.FileUtil;
import com.utils.LogUtils;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/8/16.
 */
@RouterMap("activity://test3")
public class Test3Activity extends BaseActivity {

    public static final String TAG = "Test3Activity";
    private static final String PROPERTIES_FILENAME = "project.properties";
    @BindView(R.id.recyclerview_test3)
    RecyclerView mRecyclerview;
    @BindView(R.id.bt_newimg)
    Button bt_newimg;
    @BindView(R.id.scrollview_test3)
    HorizontalScrollView mScrollView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);
        ButterKnife.bind(this);

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                1);

//        int a = 3 / 0;


        initView();

        initData();

        initEvent();

    }

    private void initView() {
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.setAdapter(new Test3Adapter());


//        String dir = FileUtil.getDir(this);
//        System.out.println("-----------------<<<>>>--------------------dir=" + dir);
//        File file = new File(dir + "/icon.jpg");
//        if (!file.exists()) {
//            boolean mkdir = false;
//            try {
//                mkdir = file.createNewFile();
//            System.out.println("-----------------<<<>>>--------------------mkdir="+mkdir);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }


    private void initData() {

    }

    private void initEvent() {
        bt_newimg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                mRecyclerview.setDrawingCacheEnabled(true);
//                Bitmap bitmap = Bitmap.createBitmap(mRecyclerview.getDrawingCache());
//                mRecyclerview.setDrawingCacheEnabled(false);
//                File file = FileUtil.saveMyBitmap(bitmap, "icon");
//                LogUtils.i(TAG, "imagepath=" + file.getAbsolutePath());
                saveImage();
            }
        });
    }

    public void saveImage() {
        new Thread() {
            @Override
            public void run() {
//                int width = 0;
//                int height = 0;
//
//                for (int i = 0; i < mRecyclerview.getChildCount(); i++) {
//                    View view = mRecyclerview.getChildAt(i);
//                    width += view.getWidth();
//                    height += view.getHeight();
//                }
//
//                Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
//                Canvas canvas = new Canvas(bitmap);
//                mRecyclerview.draw(canvas);
//                System.out.println("-----------------<<<>>>--------------------bitmap==null:" + (bitmap == null));

                Bitmap bitmap = shotRecyclerView(mRecyclerview);

                File file = FileUtil.saveMyBitmap(bitmap, "icon");
                LogUtils.i(TAG, "imagepath=" + file.getAbsolutePath());
            }
        }.start();
    }


    /**
     * https://gist.github.com/PrashamTrivedi/809d2541776c8c141d9a
     */
    public static Bitmap shotRecyclerView(RecyclerView view) {
        RecyclerView.Adapter adapter = view.getAdapter();
        Bitmap bigBitmap = null;
        if (adapter != null) {
            int size = adapter.getItemCount();
            int height = 0;
            Paint paint = new Paint();
            int iHeight = 0;
            final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

            // Use 1/8th of the available memory for this memory cache.
            final int cacheSize = maxMemory / 8;
            LruCache<String, Bitmap> bitmaCache = new LruCache<>(cacheSize);
            for (int i = 0; i < size; i++) {
                RecyclerView.ViewHolder holder = adapter.createViewHolder(view, adapter.getItemViewType(i));
                adapter.onBindViewHolder(holder, i);
                holder.itemView.measure(
                        View.MeasureSpec.makeMeasureSpec(view.getWidth(), View.MeasureSpec.EXACTLY),
                        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
                holder.itemView.layout(0, 0, holder.itemView.getMeasuredWidth(),
                        holder.itemView.getMeasuredHeight());
                holder.itemView.setDrawingCacheEnabled(true);
                holder.itemView.buildDrawingCache();
                Bitmap drawingCache = holder.itemView.getDrawingCache();
                if (drawingCache != null) {

                    bitmaCache.put(String.valueOf(i), drawingCache);
                }
                height += holder.itemView.getMeasuredHeight();
            }

            bigBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), height, Bitmap.Config.ARGB_4444);
            Canvas bigCanvas = new Canvas(bigBitmap);
            Drawable lBackground = view.getBackground();
            if (lBackground instanceof ColorDrawable) {
                ColorDrawable lColorDrawable = (ColorDrawable) lBackground;
                int lColor = lColorDrawable.getColor();
                bigCanvas.drawColor(lColor);
            }

            for (int i = 0; i < size; i++) {
                Bitmap bitmap = bitmaCache.get(String.valueOf(i));
                bigCanvas.drawBitmap(bitmap, 0f, iHeight, paint);
                iHeight += bitmap.getHeight();
                bitmap.recycle();
            }
        }
        return bigBitmap;
    }
}


//