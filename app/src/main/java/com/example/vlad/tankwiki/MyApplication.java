package com.example.vlad.tankwiki;

import android.app.Application;

public class MyApplication extends Application {
    private static MyApplication sInstance;

    MyApplication getsInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }
}
