package com.example.vlad.tankwiki.presentation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.vlad.tankwiki.R;
import com.example.vlad.tankwiki.presentation.tanks.TanksFragment;

public class MainActivity extends AppCompatActivity {
    private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentContainer = findViewById(R.id.fragment_container);

        if (savedInstanceState == null) {
            initViews();
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
