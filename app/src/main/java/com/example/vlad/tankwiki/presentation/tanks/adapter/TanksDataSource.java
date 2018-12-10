package com.example.vlad.tankwiki.presentation.tanks.adapter;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.vlad.tankwiki.data.common.UIStateType;
import com.example.vlad.tankwiki.data.model.filter.IFilterItem;
import com.example.vlad.tankwiki.data.model.filter.Nation;
import com.example.vlad.tankwiki.data.model.filter.Tier;
import com.example.vlad.tankwiki.data.model.filter.Type;
import com.example.vlad.tankwiki.data.model.tanks.Tank;
import com.example.vlad.tankwiki.data.repository.TanksRepository;
import com.example.vlad.tankwiki.data.rx.SchedulersFacade;
import com.example.vlad.tankwiki.domain.interactors.LoadDataInteractor;

import java.util.Map;
import java.util.Set;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TanksDataSource extends PageKeyedDataSource<Integer, Tank> {
    private final LoadDataInteractor _interactor;
    private final CompositeDisposable _disposable;
    private final MutableLiveData<UIStateType> _progressLiveStatus;
    private final Map<String, Set<IFilterItem>> _options;
    private int _page = 1;

    TanksDataSource(final LoadDataInteractor interactor, final Map<String, Set<IFilterItem>> options, final CompositeDisposable disposable) {
        _interactor = interactor;
        _disposable = disposable;
        _options = options;
        _progressLiveStatus = new MutableLiveData<>();
    }

    public MutableLiveData<UIStateType> getProgressLiveStatus() {
        return _progressLiveStatus;
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Tank> callback) {
        _disposable.add(
                _interactor.execute(_page, _options)
                        .doOnSubscribe(disposable -> _progressLiveStatus.postValue(UIStateType.LOADING))
                        .subscribe(
                                tanks -> {
                                    if (tanks.isEmpty()) {
                                        _progressLiveStatus.postValue(UIStateType.EMPTY);
                                    } else {
                                        _progressLiveStatus.postValue(UIStateType.LOADED);
                                        callback.onResult(tanks, null, _page++);
                                    }
                                },
                                throwable -> _progressLiveStatus.postValue(UIStateType.ERROR)
                        ));
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Tank> callback) {
        // EMPTY
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Tank> callback) {
        _disposable.add(
                _interactor.execute(_page, _options)
                        .doOnSubscribe(disposable -> _progressLiveStatus.postValue(UIStateType.LOADING_MORE))
                        .subscribe(tanks -> {
                                    _progressLiveStatus.postValue(UIStateType.LOADED);
                                    callback.onResult(tanks, _page++);
                                },
                                throwable -> _progressLiveStatus.postValue(UIStateType.ERROR)
                        ));
    }

}
