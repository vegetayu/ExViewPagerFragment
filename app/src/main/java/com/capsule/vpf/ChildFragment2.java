package com.capsule.vpf;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/11/28.
 */

public class ChildFragment2 extends Fragment {

    private TextView tvDescription;

    public static ChildFragment2 newInstance() {
        Bundle args = new Bundle();
        ChildFragment2 fragment = new ChildFragment2();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child_2, container, false);
        tvDescription = view.findViewById(R.id.tv_description);
        return view;
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
