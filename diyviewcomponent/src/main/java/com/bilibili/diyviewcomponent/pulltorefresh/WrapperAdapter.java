package com.bilibili.diyviewcomponent.pulltorefresh;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by Chihiro on 2018/7/28.
 */

class WrapperAdapter extends RecyclerView.Adapter {

    protected static final int REFRESH_HEADER = Integer.MIN_VALUE;
    protected static final int HEADER = Integer.MIN_VALUE + 1;
    protected static final int FOOTER = Integer.MAX_VALUE - 1;
    protected static final int LOAD_MORE_FOOTER = Integer.MAX_VALUE;


    private View refreshHeaderContainer;

    private View loadMoreFootContainer;

    private  RecyclerView.Adapter adapter;

    public WrapperAdapter(View refreshHeaderContainer, View loadMoreFootContainer, RecyclerView.Adapter adapter) {
        this.refreshHeaderContainer = refreshHeaderContainer;
        this.loadMoreFootContainer = loadMoreFootContainer;
        this.adapter = adapter;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType){
            case REFRESH_HEADER:
                return new RefreshHeaderViewHolder(refreshHeaderContainer);
            case LOAD_MORE_FOOTER:
                return new LoadMoreFooterViewHolder(loadMoreFootContainer);
                default:
                    return adapter.onCreateViewHolder(parent ,viewType);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(position > 0 && position < getItemCount() -1){
            adapter.onBindViewHolder(holder ,position -1);
        }
    }

    @Override
    public int getItemCount() {
        return adapter.getItemCount() +2;
    }

    @Override
    public int getItemViewType(int position) {

        if(position == 0){
            return REFRESH_HEADER;
        } else if(position == getItemCount() -1){
            return LOAD_MORE_FOOTER;
        }else {
            return super.getItemViewType(position -1);
        }
    }

    static class RefreshHeaderViewHolder extends RecyclerView.ViewHolder{

        public RefreshHeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    static class LoadMoreFooterViewHolder extends RecyclerView.ViewHolder{

        public LoadMoreFooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
