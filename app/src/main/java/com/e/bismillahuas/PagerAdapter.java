package com.e.bismillahuas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentStateAdapter{

    /*private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title)    {
        fragmentList.add(fragment);
        titleList.add(title);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }*/
    public PagerAdapter(DashBoardFragment fragmentActivity) {
        super(fragmentActivity);
    }


    @Override
    public int getItemCount() {
        return 3;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new GalonFragment();
            case 1:
                return new BotolFragment();
            default:
                return new GelasFragment();
        }
    }

    /*@Override
    public void onSend(Object o, Fragment fragment) {
        for (ITabbedFragment f:){
            if (!f.equals(fragment)) f.onReceive(o);
        }
    }*/
}
