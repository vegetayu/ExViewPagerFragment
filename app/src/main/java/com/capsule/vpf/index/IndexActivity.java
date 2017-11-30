package com.capsule.vpf.index;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.capsule.vpf.R;
import com.capsule.vpf.fp.FPActivity;
import com.capsule.vpf.frag.FragActivity;
import com.capsule.vpf.fsp.FSPActivity;
import com.capsule.vpf.pager.PagerActivity;
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
                Intent intent = null;
                switch (holder.tvTitle.getText().toString()) {
                    case "Fragment":
                        intent = new Intent(IndexActivity.this, FragActivity.class);
                        break;
                    case "ViewPager":
                        intent = new Intent(IndexActivity.this, PagerActivity.class);
                        break;
                    case "FragmentPagerAdapter":
                        intent = new Intent(IndexActivity.this, FPActivity.class);
                        break;
                    case "FragmentPagerStateAdapter":
                        intent = new Intent(IndexActivity.this, FSPActivity.class);
                        break;
                    //default:
                    //    intent = null;
                    //    break;
                }
                if (null != intent) {
                    startActivity(intent);
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
