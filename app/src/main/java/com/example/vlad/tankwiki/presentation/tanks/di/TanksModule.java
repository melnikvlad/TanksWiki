package com.example.vlad.tankwiki.presentation.tanks.di;

import android.arch.lifecycle.ViewModelProvider;

import com.example.vlad.tankwiki.data.api.ApiClient;
import com.example.vlad.tankwiki.data.repository.TanksRepository;
import com.example.vlad.tankwiki.data.rx.SchedulersFacade;
import com.example.vlad.tankwiki.domain.interactors.LoadDataInteractor;
import com.example.vlad.tankwiki.presentation.tanks.TanksViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TanksModule {

    @Provides
    @Singleton
    LoadDataInteractor provideLoadDataInteractor(TanksRepository tanksRepository) {
        return new LoadDataInteractor(tanksRepository);
    }

    @Provides
    @Singleton
    TanksRepository provideTanksRepository(ApiClient apiClient) {
        return new TanksRepository(apiClient);
    }

    @Provides
    @Singleton
    ViewModelProvider.Factory provideFactory(LoadDataInteractor loadDataInteractor) {
        return new TanksViewModelFactory(loadDataInteractor);
    }
}
