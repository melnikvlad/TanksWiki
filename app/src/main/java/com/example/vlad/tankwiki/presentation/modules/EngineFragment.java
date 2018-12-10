package com.example.vlad.tankwiki.presentation.modules;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vlad.tankwiki.R;
import com.example.vlad.tankwiki.data.model.detail.beans.Engine;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EngineFragment extends AbstractModuleFragment<Engine> {
    @BindView(R.id.text_engine_name)
    TextView textName;
    @BindView(R.id.text_engine_tier)
    TextView textTier;
    @BindView(R.id.text_engine_power)
    TextView textPower;
    @BindView(R.id.text_engine_fire)
    TextView textFireChance;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_engine, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        _detailViewModel.engine().observe(this, this::init);
    }

    @Override
    void init(final Engine engine) {
        textName.setText(engine.getName());
        textTier.setText(String.valueOf(engine.getTier()));
        textPower.setText(String.valueOf(engine.getPower()));
        textFireChance.setText(String.valueOf(engine.getFireChance()));
    }
}
