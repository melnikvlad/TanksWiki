package com.example.vlad.tankwiki.presentation.tanks;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.vlad.tankwiki.App;
import com.example.vlad.tankwiki.R;
import com.example.vlad.tankwiki.data.common.UIStateType;
import com.example.vlad.tankwiki.data.model.tanks.Tank;
import com.example.vlad.tankwiki.presentation.base.BaseFragment;
import com.example.vlad.tankwiki.presentation.tanks.adapter.TanksPagedAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TanksFragment extends BaseFragment {
    @BindView(R.id.rv_tanks)
    RecyclerView recyclerView;
    @BindView(R.id.progress)
    ProgressBar progressView;
    @BindView(R.id.progress_load_more)
    ProgressBar progressLoadMoreView;
    @BindView(R.id.errorView)
    RelativeLayout errorView;
    @BindView(R.id.text_error)
    TextView errorTextView;
    @BindView(R.id.text_empty)
    TextView emptyResultsTextView;

    @Inject
    TanksViewModelFactory _factory;

    public static final String TAG = "TanksFragment";
    private TanksViewModel _vm;
    private TanksPagedAdapter _adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getApp().getAppComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tanks, container, false);
        ButterKnife.bind(this, view);

        _vm = ViewModelProviders.of(this, _factory).get(TanksViewModel.class);

        init();
        _vm.load();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null)
            _rootVM.sharedOptions().observe(getActivity(), (opt) -> _vm.applyFilter(opt));

        _vm.status().observe(this, this::renderLoadState);

        _vm.tanksList().observe(this, (list) -> {
            _adapter.resetSelected();
            _adapter.submitList(list);
        });
    }

    private void init() {
        _adapter = new TanksPagedAdapter(getContext(), this::onTankClick);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(_adapter);
    }

    private void onTankClick(final Tank tank) {
        _rootVM.setSelectedTank(tank);
        openDetailFragment();
    }

    private void renderLoadState(final UIStateType loadState) {
        switch (loadState) {
            case LOADING:
                initLoadingState();
                break;
            case LOADING_MORE:
                initLoadingMoreState();
                break;
            case LOADED:
                initLoadedState();
                break;
            case ERROR:
                initErrorState();
                break;
            case EMPTY:
                initEmptyState();
                break;
        }
    }

    private void initLoadingState() {
        progressView.setVisibility(View.VISIBLE);
        progressLoadMoreView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
        emptyResultsTextView.setVisibility(View.GONE);
    }

    private void initLoadingMoreState() {
        progressView.setVisibility(View.GONE);
        progressLoadMoreView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
        emptyResultsTextView.setVisibility(View.GONE);
    }

    private void initLoadedState() {
        progressView.setVisibility(View.GONE);
        progressLoadMoreView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
        emptyResultsTextView.setVisibility(View.GONE);
    }


    private void initErrorState() {
        recyclerView.setVisibility(View.VISIBLE);
        progressView.setVisibility(View.GONE);
        progressLoadMoreView.setVisibility(View.GONE);
        emptyResultsTextView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
    }

    private void initEmptyState() {
        recyclerView.setVisibility(View.GONE);
        progressView.setVisibility(View.GONE);
        progressLoadMoreView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
        emptyResultsTextView.setVisibility(View.VISIBLE);
    }
}
