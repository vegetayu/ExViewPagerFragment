package com.capsule.vpf.frag;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import capsule.bamboo.Logger;
import com.capsule.vpf.R;

/**
 * Created by Administrator on 2017/12/4.
 */

public class SingleFragment extends Fragment {

    private TextView tvContent;

    private String content;

    public static SingleFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("content", content);
        SingleFragment fragment = new SingleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override public void onAttach(Context context) {
        super.onAttach(context);
        Logger.d("Fragment --> onAttach");
    }

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d("Fragment --> onCreate");
        content = getArguments().getString("content");
    }

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        Logger.d("Fragment --> onCreateView");
        View view = inflater.inflate(R.layout.fragment_single, container, false);
        tvContent = view.findViewById(R.id.tv_content);
        return view;
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Logger.d("Fragment --> onViewCreated");
        tvContent.setText(content);
    }

    @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Logger.d("Fragment --> onActivityCreated");
    }

    @Override public void onStart() {
        super.onStart();
        Logger.d("Fragment --> onStart");
    }

    @Override public void onResume() {
        super.onResume();
        Logger.d("Fragment --> onResume");
    }

    @Override public void onPause() {
        super.onPause();
        Logger.d("Fragment --> onPause");
    }

    @Override public void onStop() {
        super.onStop();
        Logger.d("Fragment --> onStop");
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        Logger.d("Fragment --> onDestroyView");
    }

    @Override public void onDestroy() {
        super.onDestroy();
        Logger.d("Fragment --> onDestroy");
    }

    @Override public void onDetach() {
        super.onDetach();
        Logger.d("Fragment --> onDetach");
    }

    @Override public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Logger.d("Fragment --> onHiddenChanged");
    }
}
