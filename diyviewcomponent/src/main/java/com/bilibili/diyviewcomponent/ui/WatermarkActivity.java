package com.bilibili.diyviewcomponent.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bilibili.diyviewcomponent.R;
import com.bilibili.diyviewcomponent.watermark.ImageWatermark;
import com.bilibili.diyviewcomponent.watermark.OnWaterInterface;
import com.bilibili.diyviewcomponent.watermark.TextWatermark;
import com.bilibili.diyviewcomponent.watermark.WatermarkActionbar;
import com.bilibili.diyviewcomponent.watermark.WatermarkBoard;

/**
 * @author 朱峰 2019/5/29
 */
public class WatermarkActivity extends AppCompatActivity {

    private WatermarkBoard watermarkBoard;

    private WatermarkActionbar bbb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diyview_act_watermark);

        bbb = findViewById(R.id.bbb);

        watermarkBoard = findViewById(R.id.watermarkBoard);
        final TextWatermark watermark = new TextWatermark(this);
        watermarkBoard.addWatermark(watermark);

        watermark.setWatermarkText("哈哈哈");

        bbb.setOnWaterClickListener(new OnWaterInterface() {
            @Override
            public void onAddImage() {

            }

            @Override
            public void onGetColor(int color) {
                watermark.setWatermarkTextColor(color);
            }

            @Override
            public void onInuptText(String text) {

            }
        });
    }
}
