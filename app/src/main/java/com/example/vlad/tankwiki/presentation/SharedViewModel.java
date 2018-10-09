package com.example.vlad.tankwiki.presentation;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<String> navigationEvent = new MutableLiveData<>();


    public void openFilterOptions(final String tag) {
        navigationEvent.setValue(tag);
    }

    MutableLiveData<String> getEvent() {
        return navigationEvent;
    }
}
