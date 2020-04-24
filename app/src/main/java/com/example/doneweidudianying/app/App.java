package com.example.doneweidudianying.app;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

public class App extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
        Fresco.initialize(this);
    }
}
