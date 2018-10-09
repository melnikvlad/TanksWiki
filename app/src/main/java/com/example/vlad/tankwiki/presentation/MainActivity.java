package com.example.vlad.tankwiki.presentation;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.vlad.tankwiki.R;
import com.example.vlad.tankwiki.presentation.filter.FilterFragment;
import com.example.vlad.tankwiki.presentation.tanks.TanksFragment;

public class MainActivity extends AppCompatActivity {
    private FrameLayout fragmentContainer;
    private SharedViewModel _vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentContainer = findViewById(R.id.fragment_container);

        _vm = ViewModelProviders.of(this).get(SharedViewModel.class);
        _vm.getEvent().observe(this, this::renderEvent);

        if (savedInstanceState == null) {
            initViews();
        }
    }

    private void renderEvent(final String tag) {
        switch (tag) {
            case FilterFragment.TAG:
                addFragment(new FilterFragment());
                break;
        }
    }

    private void initViews() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(fragmentContainer.getId(), new TanksFragment())
                .commitNow();
    }

    private void addFragment(final Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(fragmentContainer.getId(), fragment, null)
                .addToBackStack(fragment.getTag())
                .commit();
    }
}
