package com.bilibili.diyviewcomponent.d3;

import android.os.Bundle;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bilibili.diyviewcomponent.R;

public class D3Activity extends AppCompatActivity {

    private CameraImageView cameraImageView;
    private SeekBar seekBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diyview_act_d3);

        seekBar = findViewById(R.id.seekBar);
        cameraImageView = findViewById(R.id.cameraImageView);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cameraImageView.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
