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
import android.widget.TextView;

import com.bilibili.audiorecordcomponent.R;
import com.bilibili.audiorecordcomponent.audiorecord.RecordFileEncoder;
import com.bilibili.audiorecordcomponent.audiorecord.Recorder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button bt_start;
    private Button bt_stop;
    private Button bt_get_bytes;
    private TextView tv_size;

    private String[] permissions = new String[]{Manifest.permission.RECORD_AUDIO};
    private Recorder recorder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        bt_start = findViewById(R.id.bt_start);
        bt_stop = findViewById(R.id.bt_stop);
        bt_get_bytes = findViewById(R.id.bt_get_bytes);
        tv_size = findViewById(R.id.tv_size);
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
        bt_get_bytes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                File file = new File(getExternalCacheDir() + "/bytes.txt");
                File file1 = new File(getExternalCacheDir() + "/audio.aac");
//                if (!file.exists()) {
//                    try {
//                        file.createNewFile();
//
//                        InputStream inputStream = new FileInputStream(file1);
//                        OutputStream outputStream = new FileOutputStream(file);
//
//                        byte[] b = new byte[1024];
//                        int len;
//                        while ((len = inputStream.read(b)) != -1) {
//                            outputStream.write(b, 0, len);
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
                tv_size.setText(file1.length() + "");
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
