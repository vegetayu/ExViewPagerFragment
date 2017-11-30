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

public class FragmentThird extends Fragment {

    private TextView tvDescription;

    public static FragmentThird newInstance() {
        Bundle args = new Bundle();
        FragmentThird fragment = new FragmentThird();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        tvDescription = view.findViewById(R.id.tv_description);
        return view;
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
