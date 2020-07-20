package com.example.nabuint;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    private int numberoftabs;

    public PageAdapter(@NonNull FragmentManager fm, int numberoftabs) {
        super(fm);
        this.numberoftabs = numberoftabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Tab1();
            case 1:
                return new Tab2();
            case 2:
                return new Tab3();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return numberoftabs;
    }


    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
