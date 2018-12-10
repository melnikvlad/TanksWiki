package com.example.vlad.tankwiki.presentation;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.vlad.tankwiki.data.model.filter.FilterItem;
import com.example.vlad.tankwiki.data.model.filter.IFilterItem;
import com.example.vlad.tankwiki.data.model.filter.Nation;
import com.example.vlad.tankwiki.data.model.filter.Tier;
import com.example.vlad.tankwiki.data.model.filter.Type;
import com.example.vlad.tankwiki.data.model.tanks.Tank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RootViewModel extends ViewModel {
    private final MutableLiveData<Map<String, Set<IFilterItem>>> _sharedOptions = new MutableLiveData<>();
    private final MutableLiveData<Tank> _sharedTank = new MutableLiveData<>();
    private final MutableLiveData<String> _focusFrag = new MutableLiveData<>();

    void init() {
        _sharedOptions.setValue(new HashMap<>());
        _sharedTank.setValue(null);
        _focusFrag.setValue(null);
    }

    public MutableLiveData<Map<String, Set<IFilterItem>>> sharedOptions() {
        return _sharedOptions;
    }

    public MutableLiveData<Tank> getSelectedTank() {
        return _sharedTank;
    }


    public void changeSharedOptions(final Map<String, Set<IFilterItem>> newOpt) {
        _sharedOptions.postValue(newOpt);
    }

    public void setSelectedTank(final Tank tank) {
        _sharedTank.postValue(tank);
    }

    MutableLiveData<String> focusFragment() {
        return _focusFrag;
    }

    void setFocusFragment(String tag) {
        _focusFrag.setValue(tag);
    }
}
