package com.example.vlad.tankwiki.presentation.filter.di;

import com.example.vlad.tankwiki.data.repository.FilterRepository;
import com.example.vlad.tankwiki.data.rx.SchedulersFacade;
import com.example.vlad.tankwiki.domain.interactors.FilterInteractor;
import com.example.vlad.tankwiki.presentation.filter.FilterViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FilterModule {

    @Provides
    @Singleton
    FilterInteractor provideFilterInteractor(FilterRepository filterRepository) {
        return new FilterInteractor(filterRepository);
    }

    @Provides
    @Singleton
    FilterRepository provideFilterRepository() {
        return new FilterRepository();
    }

    @Provides
    @Singleton
    FilterViewModelFactory provideVMFactory(FilterInteractor interactor, SchedulersFacade schedulersFacade) {
        return new FilterViewModelFactory(interactor, schedulersFacade);
    }

}
