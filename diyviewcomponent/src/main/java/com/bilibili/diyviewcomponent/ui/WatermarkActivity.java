package com.bilibili.diyviewcomponent.ui;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bilibili.diyviewcomponent.R;
import com.bilibili.diyviewcomponent.watermark.OnWaterInterface;
import com.bilibili.diyviewcomponent.watermark.TextWatermark;
import com.bilibili.diyviewcomponent.watermark.WatermarkActionbar;
import com.bilibili.diyviewcomponent.watermark.WatermarkBoard;
import com.bilibili.diyviewcomponent.watermark.WatermarkBoardBackground;

/**
 * @author 朱峰 2019/5/29
 */
public class WatermarkActivity extends AppCompatActivity {

    private WatermarkBoard watermarkBoard;

    private WatermarkActionbar bbb;

    private Button bt_loc;

    private ImageView iv_bmp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diyview_act_watermark);

        bbb = findViewById(R.id.bbb);
        bt_loc = findViewById(R.id.bt_loc);
        iv_bmp = findViewById(R.id.iv_bmp);

        watermarkBoard = findViewById(R.id.watermarkBoard);
        final TextWatermark watermark = new TextWatermark(this);
        watermarkBoard.addBackground(new WatermarkBoardBackground(this));
        watermarkBoard.addWatermark(watermark);

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
                watermark.setWatermarkText(text);
            }

            @Override
            public void onAlphaChange(float alpha) {
                watermark.setWatermarkAlpha(1 - alpha);
            }
        });
        bt_loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(WatermarkActivity.this, watermark.getLeftRelativeToWidth()+":"
//                        +watermark.getRightRelativeToWidth()+":"
//                        +watermark.getTopRelativeToHeight()+":"
//                        +watermark.getBottomRelativeToHeight(),Toast.LENGTH_LONG).show();
                iv_bmp.setImageBitmap(watermarkBoard.getAlphaBitmap());
            }
        });

    }
}
