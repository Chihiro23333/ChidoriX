package com.bilibili.othercomponent.ui.frg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bilibili.othercomponent.R;

public class ChildFragment extends BaseFragment {

    private int type;

    public void setType(int type) {
        this.type = type;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.other_frg_child, null);
        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(type == 0){
            view.setBackgroundColor(ContextCompat.getColor(getActivity() ,android.R.color.background_dark));
        }else if(type == 1){
            view.setBackgroundColor(ContextCompat.getColor(getActivity() ,android.R.color.holo_blue_dark));
        }
    }
}
