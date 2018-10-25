package com.bilibili.audiorecordcomponent.activity;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bilibili.audiorecordcomponent.R;
import com.bilibili.audiorecordcomponent.audiorecord.RecordFileEncoder;
import com.bilibili.audiorecordcomponent.audiorecord.Recorder;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button bt_start;
    private Button bt_stop;

    private String[] permissions = new String[]{Manifest.permission.RECORD_AUDIO};
    private Recorder recorder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        bt_start = findViewById(R.id.bt_start);
        bt_stop = findViewById(R.id.bt_stop);
        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 请求权限
                ActivityCompat.requestPermissions(MainActivity.this, permissions, 100);
            }
        });
        bt_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recorder.stop();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 100) {
            File file = new File(getExternalCacheDir() + "/audio.aac");
            Log.i(TAG, file.getPath());
            if (!file.exists()) {
                try {
                    file.createNewFile();

                    RecordFileEncoder recordFileEncoder = new RecordFileEncoder(file);
                    recorder = new Recorder(recordFileEncoder);
                    recorder.prepare();
                    recorder.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}