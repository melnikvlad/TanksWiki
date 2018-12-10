package com.example.vlad.tankwiki.presentation.tree;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vlad.tankwiki.R;
import com.example.vlad.tankwiki.data.model.tanks.Module;
import com.example.vlad.tankwiki.presentation.base.BaseFragment;
import com.example.vlad.tankwiki.presentation.detail.DetailViewModel;

import java.util.Map;

import butterknife.ButterKnife;

public class TreeFragment extends BaseFragment {
    private DetailViewModel _detailViewModel;
    private TreeViewModel _vm;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_modules_tree, container, false);
        ButterKnife.bind(this, view);

        _vm = ViewModelProviders.of(this).get(TreeViewModel.class);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            _detailViewModel = ViewModelProviders.of(getActivity()).get(DetailViewModel.class);
        }
        _detailViewModel.modulesTree().observe(this, _vm::init);
    }
}
