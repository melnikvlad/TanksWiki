package com.example.vlad.tankwiki.presentation.filter;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.vlad.tankwiki.data.rx.SchedulersFacade;
import com.example.vlad.tankwiki.domain.interactors.FilterInteractor;

import javax.inject.Inject;

public class FilterViewModelFactory implements ViewModelProvider.Factory {
    private final FilterInteractor _filterInteractor;
    private final SchedulersFacade _schedulers;

    @Inject
    public FilterViewModelFactory(FilterInteractor filterInteractor, SchedulersFacade schedulers) {
        _filterInteractor = filterInteractor;
        _schedulers = schedulers;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(FilterViewModel.class)) {
            return (T) new FilterViewModel(_filterInteractor, _schedulers);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
