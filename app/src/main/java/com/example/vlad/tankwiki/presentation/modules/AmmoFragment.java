package com.example.vlad.tankwiki.presentation.modules;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vlad.tankwiki.R;
import com.example.vlad.tankwiki.data.model.detail.beans.Ammo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AmmoFragment extends AbstractModuleFragment<Ammo> {
    @BindView(R.id.penetration_type_1)
    TextView textPenetration1;
    @BindView(R.id.penetration_type_2)
    TextView textPenetration2;
    @BindView(R.id.penetration_type_3)
    TextView textPenetration3;
    @BindView(R.id.damage_type_1)
    TextView textDamage1;
    @BindView(R.id.damage_type_2)
    TextView textDamage2;
    @BindView(R.id.damage_type_3)
    TextView textDamage3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ammo, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        _detailViewModel.ammo().observe(this, this::init);
    }

    @Override
    void init(final Ammo ammo) {
        textPenetration1.setText(String.format(getString(R.string.three_val_tmpls),
                ammo.getTypes().get(0).getPenetration().get(0),
                ammo.getTypes().get(0).getPenetration().get(1),
                ammo.getTypes().get(0).getPenetration().get(2)));
        textDamage1.setText(String.format(getString(R.string.three_val_tmpls),
                ammo.getTypes().get(0).getDamage().get(0),
                ammo.getTypes().get(0).getDamage().get(1),
                ammo.getTypes().get(0).getDamage().get(2)));

        textPenetration2.setText(String.format(getString(R.string.three_val_tmpls),
                ammo.getTypes().get(1).getPenetration().get(0),
                ammo.getTypes().get(1).getPenetration().get(1),
                ammo.getTypes().get(1).getPenetration().get(2)));
        textDamage2.setText(String.format(getString(R.string.three_val_tmpls),
                ammo.getTypes().get(1).getDamage().get(0),
                ammo.getTypes().get(1).getDamage().get(1),
                ammo.getTypes().get(1).getDamage().get(2)));

        textPenetration3.setText(String.format(getString(R.string.three_val_tmpls),
                ammo.getTypes().get(2).getPenetration().get(0),
                ammo.getTypes().get(2).getPenetration().get(1),
                ammo.getTypes().get(2).getPenetration().get(2)));
        textDamage3.setText(String.format(getString(R.string.three_val_tmpls),
                ammo.getTypes().get(2).getDamage().get(0),
                ammo.getTypes().get(2).getDamage().get(1),
                ammo.getTypes().get(2).getDamage().get(2)));
    }
}
