package com.example.vlad.tankwiki.presentation.filter;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vlad.tankwiki.App;
import com.example.vlad.tankwiki.R;
import com.example.vlad.tankwiki.data.model.filter.IFilterItem;
import com.example.vlad.tankwiki.data.model.filter.Nation;
import com.example.vlad.tankwiki.data.model.filter.Tier;
import com.example.vlad.tankwiki.data.model.filter.Type;
import com.example.vlad.tankwiki.presentation.base.BaseFragment;
import com.example.vlad.tankwiki.presentation.filter.adapter.NationAdapter;
import com.example.vlad.tankwiki.presentation.filter.adapter.TierAdapter;
import com.example.vlad.tankwiki.presentation.filter.adapter.TypeAdapter;

import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilterFragment extends BaseFragment {
    public static final String TAG = "FilterFragment";

    @BindView(R.id.rv_tier)
    RecyclerView recyclerViewTier;
    @BindView(R.id.rv_type)
    RecyclerView recyclerViewType;
    @BindView(R.id.rv_nation)
    RecyclerView recyclerViewNation;

    private static final int SPAN_COUNT = 5;
    private FilterViewModel _vm;
    private TierAdapter _adapterTier;
    private TypeAdapter _adapterType;
    private NationAdapter _adapterNation;

    @Inject
    FilterViewModelFactory _factory;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getApp().getAppComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter, container, false);
        ButterKnife.bind(this, view);

        _vm = ViewModelProviders.of(this, _factory).get(FilterViewModel.class);

        init();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            _rootVM.sharedOptions().observe(getActivity(), this::renderAdapterState);
        }
        _vm.options().observe(this, _rootVM::changeSharedOptions);
    }

    private void onTierClick(final Tier tier) {
        _vm.changeTierSet(_rootVM.sharedOptions().getValue(), tier);
    }

    private void onTypeClick(final Type type) {
        _vm.changeTypeSet(_rootVM.sharedOptions().getValue(), type);
    }

    private void onNationClick(final Nation nation) {
        _vm.changeNationSet(_rootVM.sharedOptions().getValue(), nation);
    }

    private void init() {
        _adapterTier = new TierAdapter(getContext(), this::onTierClick);
        recyclerViewTier.setLayoutManager(new GridLayoutManager(getContext(), SPAN_COUNT));
        recyclerViewTier.setHasFixedSize(true);
        recyclerViewTier.setAdapter(_adapterTier);

        _adapterType = new TypeAdapter(getContext(), this::onTypeClick);
        recyclerViewType.setLayoutManager(new GridLayoutManager(getContext(), SPAN_COUNT));
        recyclerViewType.setHasFixedSize(true);
        recyclerViewType.setAdapter(_adapterType);

        _adapterNation = new NationAdapter(getContext(), this::onNationClick);
        recyclerViewNation.setLayoutManager(new GridLayoutManager(getContext(), SPAN_COUNT));
        recyclerViewNation.setHasFixedSize(true);
        recyclerViewNation.setAdapter(_adapterNation);
    }

    private void renderAdapterState(Map<String, Set<IFilterItem>> selectedOptions) {
        _adapterTier.update(selectedOptions);
        _adapterType.update(selectedOptions);
        _adapterNation.update(selectedOptions);
    }

}
