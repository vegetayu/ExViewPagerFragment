package com.capsule.vpf.index;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import com.capsule.vpf.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/30.
 */

public class IndexActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> titles;
    private IndexAdapter adapter;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        recyclerView = findViewById(R.id.rv);
        titles = initTitles();
        adapter = new IndexAdapter(titles);
        adapter.setListener(new IndexAdapter.OnItemClickListener() {
            @Override public void onClick(IndexAdapter.IndexHolder holder) {
                switch (holder.tvTitle.getText().toString()) {
                    case "Fragment":
                        break;
                    case "ViewPager":
                        break;
                    case "FragmentPagerAdapter":
                        break;
                    case "FragmentPagerStateAdapter":
                        break;
                }
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private List<String> initTitles() {
        List<String> list = new ArrayList<>();
        list.add("Fragment");
        list.add("ViewPager");
        list.add("FragmentPagerAdapter");
        list.add("FragmentPagerStateAdapter");
        return list;
    }
}
