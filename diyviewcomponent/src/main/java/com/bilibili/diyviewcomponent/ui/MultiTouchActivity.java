package com.bilibili.diyviewcomponent.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bilibili.diyviewcomponent.R;
import com.bilibili.diyviewcomponent.view.BitmapView;

public class MultiTouchActivity extends AppCompatActivity {


    private ImageView iv;
    private BitmapView bit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diyview_multi_touch);

        iv = findViewById(R.id.iv);
        bit = findViewById(R.id.bit);
        bit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bit.setDrawingCacheEnabled(true);
                Bitmap drawingCache = bit.getDrawingCache();
                iv.setImageBitmap(drawingCache);
//                bit.setDrawingCacheEnabled(false);
            }
        });


    }
}
