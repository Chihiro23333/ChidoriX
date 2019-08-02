package com.bilibili.diyviewcomponent.watermark;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import com.bilibili.diyviewcomponent.R;


public class WatermarkActionbar extends LinearLayout implements View.OnClickListener {

    private ImageView iv_add;
    private ImageView iv_keyboard;
    private ImageView iv_tt;
    private ImageView iv_paint_color;
    private WatermarkBelowView bv_view;
    private OnWaterInterface onWaterInterface;
    private boolean keyboardSeleck;
    private boolean ttSeleck;
    private boolean colorSeleck;
    private SeekBar sb_transparency;
    private static final int TTVISI = 0;
    private static final int KEYBOARDVISI = 1;
    private static final int COLORVISI = 2;
    private LinearLayout ll_definite;
    private ImageView iv_submit;
    private ImageView iv_close;

    public void setOnWaterClickListener(OnWaterInterface onWaterInterface) {
        this.onWaterInterface = onWaterInterface;
        bv_view.setOnBelowListener(onWaterInterface);
    }

    public WatermarkActionbar(Context context) {
        super(context);
    }

    public WatermarkActionbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        View mBaseView = LayoutInflater.from(context).inflate(R.layout.water_mark_view, this, true);
        iv_add = mBaseView.findViewById(R.id.iv_add);
        iv_keyboard = mBaseView.findViewById(R.id.iv_keyboard);
        iv_tt = mBaseView.findViewById(R.id.iv_tt);
        iv_paint_color = mBaseView.findViewById(R.id.iv_paint_color);
        sb_transparency = mBaseView.findViewById(R.id.sb_transparency);
        bv_view = mBaseView.findViewById(R.id.bv_view);
        ll_definite = mBaseView.findViewById(R.id.ll_definite);
        iv_submit = mBaseView.findViewById(R.id.iv_submit);
        iv_close = mBaseView.findViewById(R.id.iv_close);
        iv_add.setOnClickListener(this);
        iv_keyboard.setOnClickListener(this);
        iv_tt.setOnClickListener(this);
        iv_paint_color.setOnClickListener(this);
        iv_submit.setOnClickListener(this);
        iv_close.setOnClickListener(this);

        sb_transparency.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                onWaterInterface.onAlphaChange(i * 1f / 100);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_add:
                bv_view.setUnVisi();
                iv_tt.setImageResource(R.mipmap.tt);
                iv_paint_color.setImageResource(R.mipmap.paint_color);
                iv_keyboard.setImageResource(R.mipmap.typo);
                if (onWaterInterface != null) {
                    onWaterInterface.onAddImage();
                }
                break;
            case R.id.iv_tt:
                if (ttSeleck) {
                    ttSeleck = false;
                    bv_view.setUnVisi();
                    iv_tt.setImageResource(R.mipmap.tt);
                } else {
                    ttSeleck = true;
                    keyboardSeleck = false;
                    colorSeleck = false;
                    bv_view.setTextSizeVisi(TTVISI);
                    iv_tt.setImageResource(R.mipmap.tt_true);
                    iv_paint_color.setImageResource(R.mipmap.paint_color);
                    iv_keyboard.setImageResource(R.mipmap.typo);
                }
                break;
            case R.id.iv_keyboard:
                if (keyboardSeleck) {
                    keyboardSeleck = false;
                    bv_view.setUnVisi();
                    iv_keyboard.setImageResource(R.mipmap.typo);
                    iv_close.setVisibility(GONE);
                    iv_add.setVisibility(VISIBLE);
                    ll_definite.setVisibility(GONE);
                } else {
                    keyboardSeleck = true;
                    ttSeleck = false;
                    colorSeleck = false;
                    bv_view.setTextSizeVisi(KEYBOARDVISI);
                    iv_keyboard.setImageResource(R.mipmap.typo_true);
                    iv_tt.setImageResource(R.mipmap.tt);
                    ll_definite.setVisibility(VISIBLE);
                    iv_paint_color.setImageResource(R.mipmap.paint_color);
                    iv_close.setVisibility(VISIBLE);
                    iv_add.setVisibility(GONE);
                }
                break;

            case R.id.iv_paint_color:
                if (colorSeleck) {
                    colorSeleck = false;
                    bv_view.setUnVisi();
                    iv_paint_color.setImageResource(R.mipmap.paint_color);
                } else {
                    colorSeleck = true;
                    ttSeleck = false;
                    keyboardSeleck = false;
                    bv_view.setTextSizeVisi(COLORVISI);
                    iv_tt.setImageResource(R.mipmap.tt);
                    iv_paint_color.setImageResource(R.mipmap.paint_color_a);
                    iv_keyboard.setImageResource(R.mipmap.typo);
                }
                break;

            case R.id.iv_submit:
                //提交
                if (onWaterInterface != null) {
                    String editText = bv_view.getEditText();
                    if (!TextUtils.isEmpty(editText)) {
                        onWaterInterface.onInuptText(editText);
                        keyboardSeleck = false;
                        iv_keyboard.setImageResource(R.mipmap.typo);
                        iv_close.setVisibility(GONE);
                        iv_add.setVisibility(VISIBLE);
                        ll_definite.setVisibility(GONE);
                        bv_view.setUnVisi();
                        bv_view.setEditNull();
                    } else {
                    }
                }
                break;
            case R.id.iv_close:
                //关闭
                bv_view.setUnVisi();
                ttSeleck = false;
                keyboardSeleck = false;
                colorSeleck = false;
                iv_tt.setImageResource(R.mipmap.tt);
                iv_paint_color.setImageResource(R.mipmap.paint_color);
                iv_keyboard.setImageResource(R.mipmap.typo);
                iv_close.setVisibility(GONE);
                iv_add.setVisibility(VISIBLE);
                ll_definite.setVisibility(GONE);
                break;
        }
    }

}
