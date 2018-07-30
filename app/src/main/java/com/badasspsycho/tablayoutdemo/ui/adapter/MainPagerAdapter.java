package com.badasspsycho.tablayoutdemo.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.badasspsycho.tablayoutdemo.ui.fragment.DCFragment;
import com.badasspsycho.tablayoutdemo.ui.fragment.MarvelFragment;

public class MainPagerAdapter extends FragmentPagerAdapter {

    private final int TAB_NUMBER = 2;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MarvelFragment();
            default:
                return new DCFragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Marvel Characters";
            default:
                return "DC Characters";
        }
    }

    @Override
    public int getCount() {
        return TAB_NUMBER;
    }
}
