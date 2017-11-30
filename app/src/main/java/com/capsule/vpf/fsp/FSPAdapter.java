package com.capsule.vpf.fsp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Administrator on 2017/11/30.
 */

public class FSPAdapter extends FragmentStatePagerAdapter {

    public FSPAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override public Fragment getItem(int position) {
        return null;
    }

    @Override public int getCount() {
        return 0;
    }
}
