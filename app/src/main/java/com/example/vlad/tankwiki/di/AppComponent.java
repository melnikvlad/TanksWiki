package com.example.vlad.tankwiki.di;

import android.app.Application;

import com.example.vlad.tankwiki.presentation.base.BaseFragment;
import com.example.vlad.tankwiki.presentation.detail.DetailFragment;
import com.example.vlad.tankwiki.presentation.detail.di.DetailModule;
import com.example.vlad.tankwiki.presentation.filter.FilterFragment;
import com.example.vlad.tankwiki.presentation.filter.di.FilterModule;

import com.example.vlad.tankwiki.presentation.modules.ArmorFragment;
import com.example.vlad.tankwiki.presentation.modules.ModuleFragment;
import com.example.vlad.tankwiki.presentation.tanks.TanksFragment;
import com.example.vlad.tankwiki.presentation.tanks.di.TanksModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {
        AppModule.class,
        TanksModule.class,
        FilterModule.class,
        DetailModule.class
})
@Singleton
public interface AppComponent {
    void inject(TanksFragment tanksFragment);
    void inject(FilterFragment filterFragment);
    void inject(DetailFragment detailFragment);
    void inject(ModuleFragment moduleFragment);

    Application application();
}
