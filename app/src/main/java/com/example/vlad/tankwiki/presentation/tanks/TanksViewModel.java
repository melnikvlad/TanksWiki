package com.example.vlad.tankwiki.presentation.tanks;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.vlad.tankwiki.data.rx.ShedulersFacade;
import com.example.vlad.tankwiki.domain.interactors.LoadDataInteractor;

import io.reactivex.disposables.CompositeDisposable;

public class TanksViewModel extends ViewModel {
    private final MutableLiveData<TanksPageUIState> _state = new MutableLiveData<>();
    private final MutableLiveData<Boolean> _refreshing = new MutableLiveData<>();
    private final CompositeDisposable _disposable = new CompositeDisposable();
    private final LoadDataInteractor _loadDataInteractor;
    private final ShedulersFacade _schedulersFacade;

    TanksViewModel(LoadDataInteractor loadDataInteractor, ShedulersFacade shedulersFacade) {
        _loadDataInteractor = loadDataInteractor;
        _schedulersFacade = shedulersFacade;
    }

    void fetchData() {
        _disposable.add(
                _loadDataInteractor.executeDefault()
                        .subscribeOn(_schedulersFacade.io())
                        .observeOn(_schedulersFacade.ui())
                        .doOnSubscribe(__ -> _state.setValue(TanksPageUIState.loading()))
                        .subscribe(
                                (vehicleList) -> _state.setValue(TanksPageUIState.success(vehicleList)),
                                (throwable) -> _state.setValue(TanksPageUIState.error(throwable))));
    }

    void refreshData() {
        _disposable.add(
                _loadDataInteractor.executeDefault()
                        .subscribeOn(_schedulersFacade.io())
                        .observeOn(_schedulersFacade.ui())
                        .doOnSubscribe(__ -> _refreshing.setValue(true))
                        .subscribe(
                                (vehicleList) -> {
                                    _state.setValue(TanksPageUIState.success(vehicleList));
                                    _refreshing.setValue(false);
                                },
                                (throwable) -> {
                                    _state.setValue(TanksPageUIState.error(throwable));
                                    _refreshing.setValue(false);
                                }));
    }

    @Override
    protected void onCleared() {
        _disposable.clear();
    }

    MutableLiveData<TanksPageUIState> response() {
        return _state;
    }

    MutableLiveData<Boolean> refreshState() {
        return _refreshing;
    }

}
