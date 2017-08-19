package com.collect.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.collect.R;
import com.utils.ImageLoadUtils;

import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhangyuncai on 2017/8/15.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private Context mContext;

    public ImageAdapter(Context context) {
        this.mContext = context;
    }

    private static int[] imgs = new int[]{
            R.drawable.meinv1,
            R.drawable.meinv2,
            R.drawable.meinv3,
            R.drawable.meinv4,
            R.drawable.meinv5,
            R.drawable.meinv6,
            R.drawable.meinv7,
            R.drawable.meinv8,
            R.drawable.meinv9,
            R.drawable.meinv10,
            R.drawable.meinv11,
            R.drawable.meinv12,
            R.drawable.meinv13,
            R.drawable.meinv14,
            R.drawable.meinv15,
            R.drawable.meinv16,
            R.drawable.meinv17
    };


    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flexbox, parent, false);
        ImageViewHolder holder = new ImageViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
//        Bitmap bitmap=readBitMap(mContext,imgs[position]);
//        holder.imageview.setImageBitmap(bitmap);
//        holder.imageview.setImageResource(imgs[position]);
        String uri = "drawable://"+imgs[position];
        ImageLoadUtils.displayImage1(uri,holder.imageview,null);
    }

    @Override
    public int getItemCount() {
        return imgs.length;
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageview)
        ImageView imageview;

        public ImageViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }

    public static Bitmap readBitMap(Context context, int resId) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        //获取资源图片
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);
    }
}
