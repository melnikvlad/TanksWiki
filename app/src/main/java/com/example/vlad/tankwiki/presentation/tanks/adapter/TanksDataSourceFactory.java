package com.example.vlad.tankwiki.presentation.tanks.adapter;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;

import com.example.vlad.tankwiki.data.model.filter.IFilterItem;
import com.example.vlad.tankwiki.data.model.filter.Nation;
import com.example.vlad.tankwiki.data.model.filter.Tier;
import com.example.vlad.tankwiki.data.model.filter.Type;
import com.example.vlad.tankwiki.data.model.tanks.Tank;
import com.example.vlad.tankwiki.domain.interactors.LoadDataInteractor;

import java.util.Map;
import java.util.Set;

import io.reactivex.disposables.CompositeDisposable;

public class TanksDataSourceFactory extends DataSource.Factory<Integer, Tank> {
    private final MutableLiveData<TanksDataSource> _dataSourceLiveData;
    private final CompositeDisposable _disposable;
    private final LoadDataInteractor _interactor;
    private TanksDataSource dataSource;
    private Map<String, Set<IFilterItem>> _options;

    public TanksDataSourceFactory(final LoadDataInteractor interactor, final Map<String, Set<IFilterItem>> options, final CompositeDisposable compositeDisposable) {
        _dataSourceLiveData = new MutableLiveData<>();
        _interactor = interactor;
        _disposable = compositeDisposable;
        _options = options;
    }

    public MutableLiveData<TanksDataSource> getDataSourceLiveData() {
        return _dataSourceLiveData;
    }

    @Override
    public DataSource<Integer, Tank> create() {
        dataSource = new TanksDataSource(_interactor, _options, _disposable);
        _dataSourceLiveData.postValue(dataSource);
        return dataSource;
    }

    public void invalidate(Map<String, Set<IFilterItem>> options) {
        _options = options;
        if (dataSource != null) {
            dataSource.invalidate();
        }
    }
}
