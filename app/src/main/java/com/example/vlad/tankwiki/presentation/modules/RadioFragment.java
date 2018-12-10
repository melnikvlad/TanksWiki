package com.example.vlad.tankwiki.presentation.modules;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vlad.tankwiki.R;
import com.example.vlad.tankwiki.data.model.detail.beans.Radio;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RadioFragment extends AbstractModuleFragment<Radio> {
    @BindView(R.id.text_name)
    TextView textName;
    @BindView(R.id.text_tier)
    TextView textTier;
    @BindView(R.id.text_signal_range)
    TextView textSignalRange;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_radio, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        _detailViewModel.radio().observe(this, this::init);
    }

    @Override
    void init(final Radio radio) {
        textName.setText(radio.getName());
        textTier.setText(String.valueOf(radio.getTier()));
        textSignalRange.setText(String.valueOf(radio.getSignalRange()));
    }
}
