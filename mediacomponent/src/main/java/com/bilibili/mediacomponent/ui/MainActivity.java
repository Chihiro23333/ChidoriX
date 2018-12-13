package com.bilibili.mediacomponent.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bilibili.mediacomponent.R;
import com.bilibili.mediacomponent.camera.CameraActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_camera;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_main);

        bt_camera = findViewById(R.id.bt_camera);
        bt_camera.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_camera:
                jump(CameraActivity.class);
                break;
            default:
        }
    }

    private void jump(Class<?> c) {
        Intent intent = new Intent(MainActivity.this, c);
        startActivity(intent);
    }
}
