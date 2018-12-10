package com.example.vlad.tankwiki.presentation.tanks;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.example.vlad.tankwiki.data.common.UIStateType;
import com.example.vlad.tankwiki.data.model.filter.IFilterItem;
import com.example.vlad.tankwiki.data.model.tanks.Tank;
import com.example.vlad.tankwiki.data.rx.SchedulersFacade;
import com.example.vlad.tankwiki.domain.interactors.LoadDataInteractor;
import com.example.vlad.tankwiki.presentation.tanks.adapter.TanksDataSource;
import com.example.vlad.tankwiki.presentation.tanks.adapter.TanksDataSourceFactory;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.reactivex.disposables.CompositeDisposable;

import static com.example.vlad.tankwiki.data.api.ApiClient.DEFAULT_LIMIT;

public class TanksViewModel extends ViewModel {
    private final CompositeDisposable _disposable = new CompositeDisposable();
    private LiveData<UIStateType> _progressLoadStatus = new MutableLiveData<>();
    private final LoadDataInteractor _loadDataInteractor;
    private TanksDataSourceFactory _dataSourceFactory;
    private LiveData<PagedList<Tank>> _tanksLiveData;

    TanksViewModel(LoadDataInteractor loadDataInteractor) {
        _loadDataInteractor = loadDataInteractor;
    }

    void load() {

        final Executor executor = Executors.newFixedThreadPool(5);

        final PagedList.Config pagedListConfig = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(DEFAULT_LIMIT)
                .setPageSize(DEFAULT_LIMIT)
                .build();

        _dataSourceFactory = new TanksDataSourceFactory(_loadDataInteractor, null, _disposable);

        _tanksLiveData = new LivePagedListBuilder<>(_dataSourceFactory, pagedListConfig)
                .setFetchExecutor(executor)
                .build();

        _progressLoadStatus = Transformations.switchMap(_dataSourceFactory.getDataSourceLiveData(), TanksDataSource::getProgressLiveStatus);
    }

    void applyFilter(final Map<String, Set<IFilterItem>> options) {

        final Executor executor = Executors.newFixedThreadPool(5);

        final PagedList.Config pagedListConfig = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(DEFAULT_LIMIT)
                .setPageSize(DEFAULT_LIMIT)
                .build();

        if (_dataSourceFactory != null) {
            _dataSourceFactory.invalidate(options);

            _tanksLiveData = new LivePagedListBuilder<>(_dataSourceFactory, pagedListConfig)
                    .setFetchExecutor(executor)
                    .build();

            _progressLoadStatus = Transformations.switchMap(_dataSourceFactory.getDataSourceLiveData(), TanksDataSource::getProgressLiveStatus);
        }
    }

    LiveData<UIStateType> status() {
        return _progressLoadStatus;
    }

    LiveData<PagedList<Tank>> tanksList() {
        return _tanksLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        _disposable.clear();
    }
}
