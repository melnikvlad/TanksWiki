package com.example.vlad.tankwiki.presentation.modules;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vlad.tankwiki.R;
import com.example.vlad.tankwiki.data.model.detail.beans.Suspension;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SuspensionFragment extends AbstractModuleFragment<Suspension> {
    @BindView(R.id.text_name)
    TextView textName;
    @BindView(R.id.text_tier)
    TextView textTier;
    @BindView(R.id.text_load_limit)
    TextView textLoadLimit;
    @BindView(R.id.text_trav_speed)
    TextView textTraverseSpeed;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_suspension, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        _detailViewModel.suspension().observe(this, this::init);
    }

    @Override
    void init(final Suspension suspension) {
        textName.setText(suspension.getName());
        textTier.setText(String.valueOf(suspension.getTier()));
        textLoadLimit.setText(String.valueOf(suspension.getLoadLimit()));
        textTraverseSpeed.setText(String.valueOf(suspension.getTraverseSpeed()));
    }
}
