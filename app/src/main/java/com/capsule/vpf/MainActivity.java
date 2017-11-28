package com.capsule.vpf;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<Fragment> fragments = new ArrayList<>();

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pager);

        Fragment fragment_first = FragmentFirst.newInstance();
        Fragment fragment_second = FragmentSecond.newInstance();
        Fragment fragment_third = FragmentThird.newInstance();

        fragments.add(fragment_first);
        fragments.add(fragment_second);
        fragments.add(fragment_third);

        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        adapter.setList(fragments);

        viewPager.setAdapter(adapter);
    }

    @Override public void onBackPressed() {
        FragmentManager manager = getSupportFragmentManager();
        for (Fragment fragment : manager.getFragments()) {
            if (fragment.isVisible()) {
                FragmentManager childFm = fragment.getChildFragmentManager();
                if (childFm.getBackStackEntryCount() > 0) {
                    childFm.popBackStack();
                    return;
                }
            }
        }
        super.onBackPressed();
    }
}
