package com.example.vlad.tankwiki.di;

import android.app.Application;

import com.example.vlad.tankwiki.data.api.ApiClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    ApiClient provideApiClient() {
        return new ApiClient();
    }
}
