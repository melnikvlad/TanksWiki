package com.example.vlad.tankwiki.presentation.tanks;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.vlad.tankwiki.data.rx.ShedulersFacade;
import com.example.vlad.tankwiki.domain.interactors.LoadDataInteractor;

import io.reactivex.disposables.CompositeDisposable;

public class TanksViewModel extends ViewModel {
    private final MutableLiveData<TanksPageUIState> _state = new MutableLiveData<>();
    private final CompositeDisposable _disposable = new CompositeDisposable();
    private final LoadDataInteractor _loadDataInteractor;
    private final ShedulersFacade _schedulersFacade;

    public TanksViewModel() {
        this._loadDataInteractor = new LoadDataInteractor();
        this._schedulersFacade = new ShedulersFacade();
    }

    void fetchData() {
        _disposable.add(
                _loadDataInteractor.executeDefault()
                        .subscribeOn(_schedulersFacade.io())
                        .observeOn(_schedulersFacade.ui())
                        .doOnSubscribe(__ ->  _state.setValue(TanksPageUIState.loading()))
                        .subscribe(
                                (vehicleList) -> _state.setValue(TanksPageUIState.success(vehicleList)),
                                (throwable) -> _state.setValue(TanksPageUIState.error(throwable))));
    }

    @Override
    protected void onCleared() {
        _disposable.clear();
    }

    MutableLiveData<TanksPageUIState> response() {
        return _state;
    }

}
