package com.bilibili.diyviewcomponent.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.bilibili.diyviewcomponent.R;

public class FullScreenDialog extends Dialog {

    public FullScreenDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.diyview_dialog_fullscreen);

        getWindow().setBackgroundDrawable(new ColorDrawable(0x00000000));
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

    }

}
