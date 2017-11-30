package com.capsule.vpf.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.capsule.vpf.R;

/**
 * Created by Administrator on 2017/11/28.
 */

public class FragmentFouth extends Fragment {

    private TextView tvDescription;
    private Fragment child_1;
    private Fragment child_2;

    public static FragmentFouth newInstance() {
        Bundle args = new Bundle();
        FragmentFouth fragment = new FragmentFouth();
        fragment.setArguments(args);
        return fragment;
    }

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        child_1 = getChildFragmentManager().findFragmentByTag("child_1");
        if (child_1 == null) {
            child_1 = ChildFragment1.newInstance();
        }
        child_2 = getChildFragmentManager().findFragmentByTag("child_2");
        if (child_2 == null) {
            child_2 = ChildFragment2.newInstance();
        }
    }

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fouth, container, false);
        tvDescription = view.findViewById(R.id.tv_description);
        return view;
    }

}
