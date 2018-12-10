package com.example.vlad.tankwiki.presentation.detail.di;

import android.arch.lifecycle.ViewModelProvider;

import com.example.vlad.tankwiki.data.api.ApiClient;
import com.example.vlad.tankwiki.data.repository.ProfileRepository;
import com.example.vlad.tankwiki.data.rx.SchedulersFacade;
import com.example.vlad.tankwiki.domain.interactors.LoadProfileInteractor;
import com.example.vlad.tankwiki.presentation.detail.DetailViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailModule {
    @Provides
    @Singleton
    LoadProfileInteractor provideInteractor(ProfileRepository profileRepository) {
        return new LoadProfileInteractor(profileRepository);
    }

    @Provides
    @Singleton
    ProfileRepository provideProfileRepository(ApiClient apiClient) {
        return new ProfileRepository(apiClient);
    }

    @Provides
    @Singleton
    ViewModelProvider.Factory provideFactory(LoadProfileInteractor interactor, SchedulersFacade schedulersFacade) {
        return new DetailViewModelFactory(interactor, schedulersFacade);
    }
}
