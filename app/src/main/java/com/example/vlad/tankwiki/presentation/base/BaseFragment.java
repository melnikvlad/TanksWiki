package com.example.vlad.tankwiki.presentation.base;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.vlad.tankwiki.App;
import com.example.vlad.tankwiki.presentation.RootActivity;
import com.example.vlad.tankwiki.presentation.RootViewModel;
import com.example.vlad.tankwiki.presentation.detail.DetailFragment;
import com.example.vlad.tankwiki.presentation.detail.DetailViewModel;
import com.example.vlad.tankwiki.presentation.detail.DetailViewModelFactory;

import javax.inject.Inject;

public class BaseFragment extends Fragment {
    protected RootViewModel _rootVM;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null)
            _rootVM = ViewModelProviders.of(getActivity()).get(RootViewModel.class);
    }

    protected void openDetailFragment() {
        if (getActivity() != null)
            ((RootActivity) getActivity()).openDetailFragment();
    }
}
