package com.bilibili.diyviewcomponent.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.util.DisplayMetrics;

import com.bilibili.diyviewcomponent.R;

public class DiyViewFourActivity extends AppCompatActivity {

//    private AppCompatTextView tv_dpi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diyview_act_four);

//        tv_dpi = findViewById(R.id.tv_dpi);
//
//        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
//        int densityDpi = displayMetrics.densityDpi;
//        float density = displayMetrics.density;
//        int heightPixels = displayMetrics.heightPixels;
//        int widthPixels = displayMetrics.widthPixels;
//
//        tv_dpi.setText("densityDpi=" + densityDpi + "density=" + density + "heightPixels=" + heightPixels + "widthPixels=" + widthPixels);
    }
}
