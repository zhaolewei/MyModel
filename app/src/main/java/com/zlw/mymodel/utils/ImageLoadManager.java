package com.zlw.mymodel.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zlw.mymodel.R;

public class ImageLoadManager {

    public static void loadImage(Context context, String url, ImageView image) {
        Glide.with(context)
                .load(url)
                .fitCenter()
                .placeholder(R.drawable.common_loading)
                .crossFade()
                .into(image);
    }

    public static void loadImage(Context context, int id, ImageView image) {
        Glide.with(context)
                .load(id)
                .centerCrop()
                .placeholder(R.drawable.common_loading)
                .crossFade()
                .into(image);
    }

    public static void loadGif(Context context, String url, ImageView image) {
        Glide.with(context)
                .load(url)
                .asGif()
                .centerCrop()
                .placeholder(R.drawable.common_loading)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(image);
    }
}
