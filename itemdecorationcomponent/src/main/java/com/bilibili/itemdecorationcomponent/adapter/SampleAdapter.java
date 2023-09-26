package com.bilibili.itemdecorationcomponent.adapter;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import com.bilibili.itemdecorationcomponent.R;

public class SampleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> datas;

    private Context context;

    public SampleAdapter(List<String> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item = LayoutInflater.from(context).inflate(R.layout.item_sample,parent,false);

        return new ItemViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.tv_sample.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private AppCompatTextView tv_sample;

        public ItemViewHolder(View itemView) {
            super(itemView);

            tv_sample = itemView.findViewById(R.id.tv_sample);
        }
    }
}
