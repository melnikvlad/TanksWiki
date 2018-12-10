package com.example.vlad.tankwiki.presentation.modules;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vlad.tankwiki.R;
import com.example.vlad.tankwiki.data.model.detail.beans.Armor;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArmorFragment extends AbstractModuleFragment<Armor> {
    @BindView(R.id.text_armor_hull)
    TextView hullArmorTextView;
    @BindView(R.id.text_armor_turret)
    TextView turretArmorTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_armor, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        _detailViewModel.armor().observe(this, this::init);
    }

    @Override
    void init(final Armor armor) {
        hullArmorTextView.setText(String.format(getString(R.string.three_val_tmpls),
                armor.getHull().getFront(),
                armor.getHull().getRear(),
                armor.getHull().getSides()));
        turretArmorTextView.setText(String.format(getString(R.string.three_val_tmpls),
                armor.getTurret().getFront(),
                armor.getTurret().getRear(),
                armor.getTurret().getSides()));

    }
}
