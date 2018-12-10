package com.example.vlad.tankwiki.presentation.detail;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.vlad.tankwiki.data.rx.SchedulersFacade;
import com.example.vlad.tankwiki.domain.interactors.LoadProfileInteractor;

import javax.inject.Inject;

public class DetailViewModelFactory implements ViewModelProvider.Factory {
    private final LoadProfileInteractor _interactor;
    private final SchedulersFacade _scheduler;

    @Inject
    public DetailViewModelFactory(LoadProfileInteractor interactor, SchedulersFacade scheduler) {
       _interactor = interactor;
        _scheduler = scheduler;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DetailViewModel.class)) {
            return (T) new DetailViewModel(_interactor, _scheduler);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
