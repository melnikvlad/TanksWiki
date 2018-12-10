package com.example.vlad.tankwiki.presentation.filter;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.vlad.tankwiki.data.model.filter.IFilterItem;
import com.example.vlad.tankwiki.data.model.filter.Nation;
import com.example.vlad.tankwiki.data.model.filter.Tier;
import com.example.vlad.tankwiki.data.model.filter.Type;
import com.example.vlad.tankwiki.data.rx.SchedulersFacade;
import com.example.vlad.tankwiki.domain.interactors.FilterInteractor;

import java.util.Map;
import java.util.Set;

import io.reactivex.disposables.CompositeDisposable;

class FilterViewModel extends ViewModel {
    private final CompositeDisposable _disposable = new CompositeDisposable();
    private MutableLiveData<Map<String, Set<IFilterItem>>> _options;
    private final FilterInteractor _filterInteractor;
    private final SchedulersFacade _scheduler;

    FilterViewModel(FilterInteractor filterInteractor, SchedulersFacade schedulers) {
        _options = new MutableLiveData<>();
        _filterInteractor = filterInteractor;
        _scheduler = schedulers;
    }

    void changeTierSet(final Map<String, Set<IFilterItem>> sharedOptions, final Tier tier) {
        _disposable.add(
                _filterInteractor.changeSelectedOptions(sharedOptions, tier)
                        .subscribeOn(_scheduler.io())
                        .observeOn(_scheduler.ui())
                        .subscribe(
                                this::setOptions
                        ));
    }

    void changeTypeSet(final Map<String, Set<IFilterItem>> sharedOptions, final Type type) {
        _disposable.add(
                _filterInteractor.changeSelectedOptions(sharedOptions, type)
                        .subscribeOn(_scheduler.io())
                        .observeOn(_scheduler.ui())
                        .subscribe(
                                this::setOptions
                        ));
    }

    void changeNationSet(final Map<String, Set<IFilterItem>> sharedOptions, final Nation nation) {
        _disposable.add(
                _filterInteractor.changeSelectedOptions(sharedOptions, nation)
                        .subscribeOn(_scheduler.io())
                        .observeOn(_scheduler.ui())
                        .subscribe(
                                this::setOptions
                        ));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        _disposable.clear();
    }

    MutableLiveData<Map<String, Set<IFilterItem>>> options() {
        return _options;
    }

    void setOptions(Map<String, Set<IFilterItem>> options) {
        _options.setValue(options);
    }
}
