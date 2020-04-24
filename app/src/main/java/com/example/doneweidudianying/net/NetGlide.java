package com.example.doneweidudianying.net;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.example.doneweidudianying.R;
import com.example.doneweidudianying.app.App;

public class NetGlide {
    public static void GlideImage(String url, ImageView imageView){
        Glide.with(App.mContext).load(url)
                //错误图
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }

}
