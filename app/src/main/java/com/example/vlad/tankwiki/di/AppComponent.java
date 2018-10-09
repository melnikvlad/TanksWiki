package com.example.vlad.tankwiki.di;

import android.app.Application;

import com.example.vlad.tankwiki.presentation.tanks.TanksFragment;
import com.example.vlad.tankwiki.presentation.tanks.di.TanksModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {
        AppModule.class,
        TanksModule.class
})
@Singleton
public interface AppComponent {
    void inject(TanksFragment tanksFragment);

    Application application();
}
