package com.example.vlad.tankwiki.presentation;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.vlad.tankwiki.R;
import com.example.vlad.tankwiki.presentation.detail.DetailFragment;
import com.example.vlad.tankwiki.presentation.filter.FilterFragment;
import com.example.vlad.tankwiki.presentation.tanks.TanksFragment;

public class RootActivity extends AppCompatActivity {
    private static final String LAST_VISIBLE_FRAG = "fragment on focus";
    private RootViewModel _vm;
    private FrameLayout mainContainer;
    private FrameLayout additionalContainer;
    private boolean _isTwoPane = false;
    private FragmentManager _fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainContainer = findViewById(R.id.fragment_container);

        _vm = ViewModelProviders.of(this).get(RootViewModel.class);

        determinePaneLayout();

        if (savedInstanceState == null) {
            initDefaultContainer();
            _vm.init();
        } else {
            restoreViews(savedInstanceState.getString(LAST_VISIBLE_FRAG));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(LAST_VISIBLE_FRAG, _vm.focusFragment().getValue());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.filter:
                openFilterFragment();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initDefaultContainer() {
        _fm.beginTransaction()
                .add(mainContainer.getId(), new TanksFragment(), TanksFragment.TAG)
                .commit();
    }

    private void restoreViews(final String focusedFragmentTag) {
        if (_isTwoPane) {
            restoreMainContainer();
            restoreAdditionalContainer(focusedFragmentTag);
        } else {
            restoreMainContainerWith(focusedFragmentTag);
        }
    }

    private void restoreMainContainerWith(final String tag) {
        Fragment tanksFragment = _fm.findFragmentByTag(TanksFragment.TAG);
        Fragment focusFragment = getFragmentBy(tag);

        if (tanksFragment != null && focusFragment != null)
            _fm.beginTransaction()
                    .replace(mainContainer.getId(), tanksFragment)
                    .replace(mainContainer.getId(), focusFragment).addToBackStack(null)
                    .commit();
    }

    private void restoreMainContainer() {
        Fragment tanksFragment = _fm.findFragmentByTag(TanksFragment.TAG);

        if (tanksFragment != null)
            _fm.beginTransaction()
                    .replace(mainContainer.getId(), tanksFragment)
                    .commit();
    }

    private void restoreAdditionalContainer(final String tag) {
        addFragment(additionalContainer.getId(), getFragmentBy(tag), tag, false);
    }

    private void openFilterFragment() {
        if (_isTwoPane) {
            addFragment(additionalContainer.getId(), new FilterFragment(), FilterFragment.TAG, false);
        } else {
            addFragment(mainContainer.getId(), new FilterFragment(), FilterFragment.TAG, true);
        }
    }

    public void openDetailFragment() {
        if (_isTwoPane) {
            addFragment(additionalContainer.getId(), new DetailFragment(), DetailFragment.TAG, false);
        } else {
            addFragment(mainContainer.getId(), new DetailFragment(), DetailFragment.TAG, true);
        }
    }

    private void addFragment(final int containerId, final Fragment fragment, final String tag, final boolean addToStack) {
        if (fragment != null) {
            _vm.setFocusFragment(tag);

            FragmentTransaction fragmentTransaction = _fm.beginTransaction();

            fragmentTransaction.replace(containerId, fragment, tag);

            if (addToStack) fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();
        }
    }

    private void determinePaneLayout() {
        additionalContainer = findViewById(R.id.fragment_container_2);
        if (additionalContainer != null) {
            _isTwoPane = true;
        }
    }

    private Fragment getFragmentBy(final String tag) {
        switch (tag) {
            case DetailFragment.TAG:
                return new DetailFragment();
            case FilterFragment.TAG:
                return new FilterFragment();
            default:
                return null;
        }
    }
}
