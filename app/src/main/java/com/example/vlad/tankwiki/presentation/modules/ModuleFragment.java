package com.example.vlad.tankwiki.presentation.modules;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.vlad.tankwiki.App;
import com.example.vlad.tankwiki.presentation.base.BaseFragment;
import com.example.vlad.tankwiki.presentation.detail.DetailViewModel;
import com.example.vlad.tankwiki.presentation.detail.DetailViewModelFactory;

import javax.inject.Inject;

public class ModuleFragment extends BaseFragment {
    protected DetailViewModel _detailViewModel;

    @Inject
    DetailViewModelFactory _factory;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getApp().getAppComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getParentFragment() != null)
            _detailViewModel = ViewModelProviders.of(getParentFragment(), _factory).get(DetailViewModel.class);
    }
}
