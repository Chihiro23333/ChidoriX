package com.bilibili.diyviewcomponent.ui;

import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.bilibili.diyviewcomponent.R;
import com.bilibili.diyviewcomponent.util.Utils;

public class DiyViewFourActivity extends AppCompatActivity {

    private AppCompatTextView tv_dpi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diyview_act_four);

        tv_dpi = findViewById(R.id.tv_dpi);

        WindowManager wm = getWindowManager();
        Point point = new Point();
        Display defaultDisplay = wm.getDefaultDisplay();
        if (Build.VERSION.SDK_INT < 17) {
            defaultDisplay.getSize(point);
        } else {
            defaultDisplay.getRealSize(point);
        }
        int width = point.x;
        int height = point.y;


        defaultDisplay.getSize(point);
        int width1 = point.x;
        int height1 = point.y;

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int densityDpi = displayMetrics.densityDpi;
        float density = displayMetrics.density;

        int heightPixels = displayMetrics.heightPixels;
        int widthPixels = displayMetrics.widthPixels;
//
        tv_dpi.setText("densityDpi=" + densityDpi + "density=" + density + "heightPixels=" + heightPixels + "widthPixels=" + widthPixels
                + "width+width1" + width + "/" + width1 + "height+height1" + height + "/" + height1
                + "checkDeviceHasNavigationBar" + Utils.checkDeviceHasNavigationBar(DiyViewFourActivity.this)
                + "getNavigationBarHeight" + Utils.getNavigationBarHeight(DiyViewFourActivity.this));

    }
}
