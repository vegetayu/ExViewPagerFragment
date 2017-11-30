package com.capsule.vpf.fp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/28.
 */

public class FPAdapter extends FragmentPagerAdapter {

    private List<Fragment> list = new ArrayList<>();

    public void setList(List<Fragment> list) {
        this.list = list;
    }

    public FPAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override public int getCount() {
        return list.size();
    }
}
