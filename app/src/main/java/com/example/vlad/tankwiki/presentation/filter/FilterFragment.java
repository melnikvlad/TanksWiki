package com.example.vlad.tankwiki.presentation.filter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.vlad.tankwiki.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilterFragment extends Fragment {
    @BindView(R.id.rv_tier)
    RecyclerView recyclerViewTier;

    public static final String TAG = "FilterFragment";
    private TierAdapter _adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter, container, false);
        ButterKnife.bind(this, view);

        initRecyclerTier();

        return view;
    }

    private void initRecyclerTier() {
        _adapter = new TierAdapter(getContext());
        recyclerViewTier.setLayoutManager(new GridLayoutManager(getContext(), 5));
        recyclerViewTier.setAdapter(_adapter);
    }
}
