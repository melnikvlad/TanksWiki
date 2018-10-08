package com.example.vlad.tankwiki.presentation.tanks;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.vlad.tankwiki.data.rx.ShedulersFacade;
import com.example.vlad.tankwiki.domain.interactors.LoadDataInteractor;

public class TanksViewModelFactory implements ViewModelProvider.Factory {
//    private final LoadDataInteractor _loadDataInteractor;
//    private final ShedulersFacade _shedulersFacade;

    public TanksViewModelFactory() {
//        _loadDataInteractor = loadDataInteractor;
//        _shedulersFacade = shedulersFacade;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(TanksViewModel.class)) {
            return (T) new TanksViewModel();
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
