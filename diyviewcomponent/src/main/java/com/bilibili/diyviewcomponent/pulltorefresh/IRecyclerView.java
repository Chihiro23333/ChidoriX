package com.bilibili.diyviewcomponent.pulltorefresh;


import android.content.Context;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.bilibili.diyviewcomponent.R;

/**
 * Created by Chihiro on 2018/7/28.
 */

public class IRecyclerView extends RecyclerView {

    private RefreshHeaderLayout refreshHeaderContainer;

    private FrameLayout loadMoreFootContainer;

    public IRecyclerView(Context context) {
        this(context ,null);
    }

    public IRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs ,0);
    }

    public IRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        init();

    }

    private void init() {

        ensureRefreshHeaerContainer();

        ensureLoadMoreFooterContainer();

        addRefreshHeaderContainer();

        addLoadMoreFooterContainer();

    }

    private void addLoadMoreFooterContainer() {
        View header = View.inflate(getContext(), R.layout.diyview_desgin_refresh_footer, null);

        loadMoreFootContainer.addView(header);
    }

    private void addRefreshHeaderContainer() {
        View header = View.inflate(getContext(), R.layout.diyview_desgin_refresh_header, null);

        refreshHeaderContainer.addView(header);
    }

    private void ensureLoadMoreFooterContainer() {
        if(loadMoreFootContainer !=null){
            loadMoreFootContainer.removeAllViews();
        }

        loadMoreFootContainer = new FrameLayout(getContext());
    }

    private void ensureRefreshHeaerContainer() {
        if(refreshHeaderContainer !=null){
            refreshHeaderContainer.removeAllViews();
        }

        refreshHeaderContainer = new RefreshHeaderLayout(getContext());
    }

    public void setIAdapter(Adapter adapter) {
        setAdapter(new WrapperAdapter(refreshHeaderContainer ,loadMoreFootContainer ,adapter));
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        int actionMasked = e.getActionMasked();
        return super.onInterceptTouchEvent(e);
    }
}
