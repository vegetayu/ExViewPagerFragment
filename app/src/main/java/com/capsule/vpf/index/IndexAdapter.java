package com.capsule.vpf.index;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.capsule.vpf.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/30.
 */

public class IndexAdapter extends RecyclerView.Adapter<IndexAdapter.IndexHolder> {

    private RecyclerView mRecyclerView;
    private List<String> list = new ArrayList<>();

    public IndexAdapter(List<String> list) {
        this.list = list;
    }

    @Override public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }

    @Override public IndexHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = mRecyclerView.getContext();
        View layout = LayoutInflater.from(context).inflate(R.layout.item_index, parent,false);
        return new IndexHolder(layout);
    }

    @Override public void onBindViewHolder(final IndexHolder holder,  int position) {
        String item = list.get(position);
        holder.tvTitle.setText(item);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (listener == null) {
                    return;
                }
                listener.onClick(holder);
            }
        });
    }

    @Override public int getItemCount() {
        return list.size();
    }

    class IndexHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;

        IndexHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.index_title);
        }
    }

    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onClick(final IndexHolder holder);
    }
}
