package com.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.io.File;

/**
 * Created by zhangyuncai on 2017/8/4.
 */

public class ImageLoadUtils {
    public static void initOptions(Context context) {
        try {
            ImageLoader imageLoader = ImageLoader.getInstance();
            if (!imageLoader.isInited()) {

                File cacheDir = context.getCacheDir();

                DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                        .showImageOnFail(android.R.color.transparent)
                        .imageScaleType(ImageScaleType.EXACTLY)
                        .resetViewBeforeLoading(false)
                        .showImageOnLoading(android.R.color.transparent)
                        .cacheOnDisk(true) // default
                        .bitmapConfig(Bitmap.Config.RGB_565) // default
                        .cacheInMemory(true)
//                    .showImageForEmptyUri(0)
                        .build();

//                DiskCache
                ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
                        .memoryCacheSize(2 * 1024 * 1024)
                        .diskCacheFileCount(100)
                        .defaultDisplayImageOptions(defaultOptions)
                        .memoryCache(new WeakMemoryCache())
//                        .diskCache(new LruDiscCache(cacheDir, new HashCodeFileNameGenerator(), 50 * 1024 * 1024))
                        .build();

                imageLoader.init(configuration);

                imageLoader.handleSlowNetwork(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayImage1(String uri, ImageView imageView, DisplayImageOptions options) {
        displayImage0(uri, imageView, options);
    }


    public static void displayImage2(String uri, ImageView imageView, ImageLoadingListener loadingListener) {
        displayImage0(uri, imageView, loadingListener);
    }


    public static void displayImage3(String uri, ImageView imageView, DisplayImageOptions options, ImageLoadingListener loadingListener) {
        displayImage0(uri, imageView, options, loadingListener);
    }

    public static void displayImage0(String uri, ImageView imageView, DisplayImageOptions options) {
        try {
            ImageLoader.getInstance().displayImage(uri, imageView, options);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void displayImage0(String uri, ImageView imageView, ImageLoadingListener loadingListener) {
        try {
            ImageLoader.getInstance().displayImage(uri, imageView, loadingListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayImage0(String uri, ImageView imageView, DisplayImageOptions options, ImageLoadingListener loadingListener) {
        try {
            ImageLoader.getInstance().displayImage(uri, imageView, options, loadingListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DisplayImageOptions getOption(int drawable) {
        DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(drawable)
                .showImageOnLoading(drawable)
                .showImageOnFail(drawable)
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .build();

        return displayImageOptions;
    }

}
