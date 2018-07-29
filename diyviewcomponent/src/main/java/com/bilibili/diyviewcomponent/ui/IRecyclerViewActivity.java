package com.bilibili.diyviewcomponent.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bilibili.diyviewcomponent.R;
import com.bilibili.diyviewcomponent.pulltorefresh.IRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chihiro on 2018/7/28.
 */

public class IRecyclerViewActivity extends AppCompatActivity {

    private IRecyclerView ir;
    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diyview_act_i_recyclerview);

        ir = findViewById(R.id.ir);

        for (int i = 0; i < 20; i++) {
            list.add("item="+i);
        }

        ir.setIAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View item = View.inflate(IRecyclerViewActivity.this, R.layout.diyview_item_i_recyclerview, null);

                return new ItemViewHolder(item);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

                itemViewHolder.tv_item.setText(list.get(position));
            }

            @Override
            public int getItemCount() {
                return list.size();
            }
        });

        ir.setLayoutManager(new LinearLayoutManager(IRecyclerViewActivity.this));
        ir.addItemDecoration(new DividerItemDecoration(IRecyclerViewActivity.this , DividerItemDecoration.VERTICAL));
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder{


        private AppCompatTextView tv_item;

        public ItemViewHolder(View itemView) {
            super(itemView);

            tv_item = itemView.findViewById(R.id.tv_item);
        }
    }
}
