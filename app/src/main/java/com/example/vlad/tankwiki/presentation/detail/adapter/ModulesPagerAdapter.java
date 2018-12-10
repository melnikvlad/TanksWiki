package com.example.vlad.tankwiki.presentation.detail.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.vlad.tankwiki.presentation.modules.AmmoFragment;
import com.example.vlad.tankwiki.presentation.modules.ArmorFragment;
import com.example.vlad.tankwiki.presentation.modules.EngineFragment;
import com.example.vlad.tankwiki.presentation.modules.GunFragment;
import com.example.vlad.tankwiki.presentation.modules.RadioFragment;
import com.example.vlad.tankwiki.presentation.modules.SuspensionFragment;

public class ModulesPagerAdapter extends FragmentStatePagerAdapter {
    public final static int MODULES_COUNT = 6;

    public ModulesPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

    @Override
    public Fragment getItem(int pos) {
        Fragment fragment = null;
        switch (pos) {
            case 0:
                fragment = new ArmorFragment();
                break;
            case 1:
                fragment = new GunFragment();
                break;
            case 2:
                fragment = new AmmoFragment();
                break;
            case 3:
                fragment = new EngineFragment();
                break;
            case 4:
                fragment = new SuspensionFragment();
                break;
            case 5:
                fragment = new RadioFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return MODULES_COUNT;
    }
}
