package com.example.vlad.tankwiki.presentation.detail;

import android.arch.lifecycle.ViewModelProviders;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.vlad.tankwiki.App;
import com.example.vlad.tankwiki.R;
import com.example.vlad.tankwiki.data.common.UIProfileState;
import com.example.vlad.tankwiki.data.model.detail.state.MainInfo;
import com.example.vlad.tankwiki.presentation.base.BaseFragment;
import com.example.vlad.tankwiki.presentation.detail.adapter.ModulesPagerAdapter;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.util.Objects.requireNonNull;

public class DetailFragment extends BaseFragment {
    public static final String TAG = "TankDetailFragment";
    private static final int MAX_LINES_MIN = 3;
    private static final int MAX_LINES_TOP = 100;
    private final int[] tabIcons = {
            R.drawable.ic_armor,
            R.drawable.ic_gun,
            R.drawable.ic_ammo,
            R.drawable.ic_engine,
            R.drawable.ic_suspension,
            R.drawable.ic_radio
    };

    @BindView(R.id.progress)
    ProgressBar progressView;
    @BindView(R.id.imgTank)
    ImageView tankImage;
    @BindView(R.id.text_name)
    TextView nameTextView;
    @BindView(R.id.text_description)
    TextView descriptionTextView;
    @BindView(R.id.text_tier)
    TextView tierTextView;
    @BindView(R.id.text_type)
    TextView typeTextView;
    @BindView(R.id.text_expand)
    TextView expandDescriptionTextView;
    @BindView(R.id.viewPager)
    ViewPager pagerView;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @Inject
    DetailViewModelFactory _factory;

    private DetailViewModel _vm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getApp().getAppComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, view);

        _vm = ViewModelProviders.of(this, _factory).get(DetailViewModel.class);
        _vm.descriptionState().observe(this, this::renderDescriptionState);
        _vm.state().observe(this, this::renderState);
        _vm.main().observe(this, this::init);

        initPager();

        expandDescriptionTextView.setOnClickListener(v -> onExpandDescriptionClick());

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null)
            _rootVM.getSelectedTank().observe(getActivity(), _vm::loadData);
    }

    private void renderState(final UIProfileState profileState) {
        switch (profileState.getState()) {
            case LOADED:
                initLoadedState();
                break;
            case LOADING:
                initLoadingState();
                break;
            case ERROR:
                initErrorState(profileState.getThrowable());
                break;
        }
    }

    private void init(final MainInfo data) {
        Picasso.get().load(data.getImage()).into(tankImage);
        nameTextView.setText(data.getName());
        descriptionTextView.setText(data.getDescription());
        tierTextView.setText(String.format(getString(R.string.tier_tmpl), data.getTier()));
        typeTextView.setText(data.getType());
    }

    private void initLoadingState() {
        progressView.setVisibility(View.VISIBLE);
    }


    private void initLoadedState() {
        expandDescriptionTextView.setVisibility(View.VISIBLE);
        progressView.setVisibility(View.GONE);
    }

    private void initErrorState(final Throwable throwable) {
        progressView.setVisibility(View.GONE);
    }

    private void renderDescriptionState(final boolean more) {
        if (more) {
            descriptionTextView.setMaxLines(MAX_LINES_TOP);
            expandDescriptionTextView.setText(getString(R.string.show_less));
        } else {
            descriptionTextView.setMaxLines(MAX_LINES_MIN);
            expandDescriptionTextView.setText(getString(R.string.show_more));
        }
    }

    private void onExpandDescriptionClick() {
        _vm.onDescriptionClick(_vm.descriptionState().getValue());
    }

    private void initPager() {
        final ModulesPagerAdapter pagerAdapter = new ModulesPagerAdapter(getChildFragmentManager());
        pagerView.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(pagerView);
        setIcons();
    }

    private void setIcons() {
        ColorStateList colors;
        if (Build.VERSION.SDK_INT >= 23 && getActivity() != null) {
            colors = getResources().getColorStateList(R.color.tab_icon, getActivity().getTheme());
        } else {
            colors = getResources().getColorStateList(R.color.tab_icon);
        }

        TabLayout.Tab tab;
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setIcon(tabIcons[i]);
                Drawable icon = tab.getIcon();
                if (icon != null) {
                    icon = DrawableCompat.wrap(icon);
                    DrawableCompat.setTintList(icon, colors);
                }
            }
        }
    }

}
