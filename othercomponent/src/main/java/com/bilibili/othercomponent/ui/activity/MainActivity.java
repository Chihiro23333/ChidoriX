package com.bilibili.othercomponent.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bilibili.othercomponent.R;
import com.bilibili.othercomponent.ui.notification.NotificationActivity;

public class MainActivity extends AppCompatActivity {

    private Button bt_notifacation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_main);

        bt_notifacation = findViewById(R.id.bt_notifacation);
        bt_notifacation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(NotificationActivity.class);
            }
        });

    }

    private void jump(Class<?> c) {
        Intent intent = new Intent(MainActivity.this, c);
        startActivity(intent);
    }
}
