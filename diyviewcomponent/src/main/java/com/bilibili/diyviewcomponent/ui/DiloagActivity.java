package com.bilibili.diyviewcomponent.ui;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.bilibili.diyviewcomponent.R;
import com.bilibili.diyviewcomponent.dialog.FullScreenDialog;
import com.bilibili.diyviewcomponent.dialog.FullScreenDialogFragment;

public class DiloagActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_full;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.diyview_act_dialog);

//        getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLUE));
//        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0 全透明实现
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            //设置导航栏颜色
            getWindow().setNavigationBarColor(Color.RED);
        } else {//4.4 全透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }


        bt_full = findViewById(R.id.bt_full);
        bt_full.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_full:
                showFullScreenDialog();
                break;
        }
    }

    private void showFullScreenDialog() {
//        FullScreenDialog fullScreenDialog = new FullScreenDialog(DiloagActivity.this);
//        fullScreenDialog.show();

//        FullScreenDialogFragment fullScreenDialogFragment =new FullScreenDialogFragment();
//        fullScreenDialogFragment.show(getSupportFragmentManager() ,"FullScreenDialogFragment");
    }
}
