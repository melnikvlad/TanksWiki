package com.example.vlad.tankwiki;

import android.app.Application;

import com.example.vlad.tankwiki.di.AppComponent;
import com.example.vlad.tankwiki.di.AppModule;
import com.example.vlad.tankwiki.di.DaggerAppComponent;
import com.example.vlad.tankwiki.presentation.tanks.di.TanksModule;


public class App extends Application {
    private static App sInstance;
    private AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(sInstance))
                .tanksModule(new TanksModule())
                .build();
    }

    public static App getApp() {
        return sInstance;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
