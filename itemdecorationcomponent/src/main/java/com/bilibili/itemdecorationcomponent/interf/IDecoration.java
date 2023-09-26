package com.bilibili.itemdecorationcomponent.interf;

import androidx.appcompat.widget.RecyclerView;
import android.view.View;

public interface IDecoration {
    int[] getItemOffsets(View view, RecyclerView parent, RecyclerView.State state);
    int[] getDrawOffsets(RecyclerView parent, RecyclerView.State state);

}
