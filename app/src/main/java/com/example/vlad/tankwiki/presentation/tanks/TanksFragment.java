package com.example.vlad.tankwiki.presentation.tanks;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
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
import com.example.vlad.tankwiki.data.model.Tank;
import com.example.vlad.tankwiki.presentation.SharedViewModel;
import com.example.vlad.tankwiki.presentation.filter.FilterFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TanksFragment extends Fragment {
    @BindView(R.id.rv_tanks)
    RecyclerView recyclerView;
    @BindView(R.id.progress)
    ProgressBar progressView;
    @BindView(R.id.errorView)
    RelativeLayout errorView;
    @BindView(R.id.text_error)
    TextView errorTextView;
    @BindView(R.id.swipeToRefresh)
    SwipeRefreshLayout refreshView;
    @BindView(R.id.button_open_filter)
    FloatingActionButton buttonOpenFilter;

    @Inject
    TanksViewModelFactory _factory;

    private TanksViewModel _vm;
    private SharedViewModel _sharedVM;
    private TanksAdapter _adapter;

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
        _vm.response().observe(this, this::renderState);
        _vm.refreshState().observe(this, this::renderRefreshState);

        refreshView.setOnRefreshListener(() -> _vm.refreshData());
        buttonOpenFilter.setOnClickListener((view1 -> openFilterOptions()));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initDefaultRecyclerViewState();
        _vm.fetchData();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null)
            _sharedVM = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
    }

    private void renderState(final TanksPageUIState state) {
        switch (state.state) {
            case LOADING:
                initLoadingState();
                break;
            case ERROR:
                initErrorState(state.throwable);
                break;
            case SUCCESS:
                initDataState(state.data);
                break;
        }
    }

    private void renderRefreshState(Boolean isRefreshing) {
        if (isRefreshing) {
            initRefreshingState();
        } else {
            initRefreshingFinishedState();
        }
    }

    private void initDataState(final List<Tank> data) {
        progressView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
        _adapter.add(data);
    }

    private void initErrorState(final Throwable throwable) {
        recyclerView.setVisibility(View.GONE);
        progressView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
        errorTextView.setText(throwable.getMessage());
    }

    private void initLoadingState() {
        progressView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
    }

    private void initRefreshingState() {
        _adapter.clear();
    }

    private void initRefreshingFinishedState() {
        refreshView.setRefreshing(false);
    }

    private void initDefaultRecyclerViewState() {
        _adapter = new TanksAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(_adapter);
    }

    private void openFilterOptions() {
        _sharedVM.openFilterOptions(FilterFragment.TAG);
    }
}
