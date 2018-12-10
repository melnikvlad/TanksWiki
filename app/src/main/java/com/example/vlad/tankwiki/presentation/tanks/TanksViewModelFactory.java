package com.example.vlad.tankwiki.presentation.tanks;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.vlad.tankwiki.data.rx.SchedulersFacade;
import com.example.vlad.tankwiki.domain.interactors.LoadDataInteractor;

import javax.inject.Inject;

public class TanksViewModelFactory implements ViewModelProvider.Factory {
    private final LoadDataInteractor _loadDataInteractor;

    @Inject
    public TanksViewModelFactory(LoadDataInteractor loadDataInteractor) {
        _loadDataInteractor = loadDataInteractor;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(TanksViewModel.class)) {
            return (T) new TanksViewModel(_loadDataInteractor);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
