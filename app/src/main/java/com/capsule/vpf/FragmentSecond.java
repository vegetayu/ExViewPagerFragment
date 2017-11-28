package com.capsule.vpf;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/11/28.
 */

public class FragmentSecond extends Fragment {

    private TextView tvDescription;
    private Fragment child_1;
    private Fragment child_2;

    public static FragmentSecond newInstance() {
        Bundle args = new Bundle();
        FragmentSecond fragment = new FragmentSecond();
        fragment.setArguments(args);
        return fragment;
    }

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        child_1 = getChildFragmentManager().findFragmentByTag("child_1");
        if (child_1 == null) {
            child_1 = ChildFragment1.newInstance();
        }
        child_2 = getChildFragmentManager().findFragmentByTag("child_2");
        if (child_2 == null) {
            child_2 = ChildFragment2.newInstance();
        }
    }

    @Override public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_second, menu);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.set_child_1:
                getChildFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, child_1, "child_1")
                    .addToBackStack("child_1")
                    .commit();
                //new Handler().postDelayed(new Runnable() {
                //    @Override public void run() {
                //        getChildFragmentManager().popBackStack();
                //    }
                //}, 3000);
                break;
            case R.id.set_child_2:
                getChildFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, child_2, "child_2")
                    .addToBackStack("child_2")
                    .commit();
                break;
        }
        return true;
    }

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        tvDescription = view.findViewById(R.id.tv_description);
        return view;
    }

}
