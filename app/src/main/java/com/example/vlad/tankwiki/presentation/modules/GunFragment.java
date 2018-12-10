package com.example.vlad.tankwiki.presentation.modules;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vlad.tankwiki.R;
import com.example.vlad.tankwiki.data.model.detail.beans.Gun;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GunFragment extends AbstractModuleFragment<Gun> {
    @BindView(R.id.text_name)
    TextView textName;
    @BindView(R.id.text_tier)
    TextView textTier;
    @BindView(R.id.text_caliber)
    TextView textCaliber;
    @BindView(R.id.text_reload)
    TextView textReloadTime;
    @BindView(R.id.text_aim)
    TextView textAimTime;
    @BindView(R.id.text_fire_rate)
    TextView textFireRate;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gun, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        _detailViewModel.gun().observe(this, this::init);
    }

    @Override
    void init(final Gun gun) {
        textName.setText(String.valueOf(gun.getName()));
        textTier.setText(String.valueOf(gun.getTier()));
        textCaliber.setText(String.valueOf(gun.getCaliber()));
        textReloadTime.setText(String.valueOf(gun.getReloadTime()));
        textAimTime.setText(String.valueOf(gun.getAimTime()));
        textFireRate.setText(String.valueOf(gun.getFireRate()));
    }
}
