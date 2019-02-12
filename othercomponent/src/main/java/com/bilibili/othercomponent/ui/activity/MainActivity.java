package com.bilibili.othercomponent.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bilibili.othercomponent.R;
import com.bilibili.othercomponent.ui.frg.FrgActivity;
import com.bilibili.othercomponent.ui.fragment.TestFragmentActivity;
import com.bilibili.othercomponent.ui.layoutmanager.CustomLayoutManagerActivity;
import com.bilibili.othercomponent.ui.notification.NotificationActivity;
import com.bilibili.othercomponent.ui.snaphelper.SnapHelperActivity;

public class MainActivity extends AppCompatActivity {

    private Button bt_notifacation;
    private Button bt_layoutmanager;
    private Button bt_snaphelper;
    private Button bt_fragment;
    private Button bt_frg_act;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_main);

        bt_notifacation = findViewById(R.id.bt_notifacation);
        bt_layoutmanager = findViewById(R.id.bt_layoutmanager);
        bt_snaphelper = findViewById(R.id.bt_snaphelper);
        bt_frg_act = findViewById(R.id.bt_frg_act);
        bt_fragment = findViewById(R.id.bt_fragment);
        bt_notifacation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(NotificationActivity.class);
            }
        });
        bt_layoutmanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(CustomLayoutManagerActivity.class);
            }
        });
        bt_snaphelper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(SnapHelperActivity.class);
            }
        });
        bt_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(TestFragmentActivity.class);
            }
        });
        bt_frg_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(FrgActivity.class);
            }
        });

    }

    private void jump(Class<?> c) {
        Intent intent = new Intent(MainActivity.this, c);
        startActivity(intent);
    }
}
