package com.bilibili.diyviewcomponent.watermark;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bilibili.diyviewcomponent.R;


public class WatermarkBelowView extends FrameLayout {

    private LinearLayout ll_text_size;
    private LinearLayout ll_input;
    private LinearLayout ll_paint_color;
    private FrameLayout fl_item;
    private EditText et_input;
    private SeekBar sb_text_size;
    private OnWaterInterface onBelowColor;

    public WatermarkBelowView(@NonNull Context context) {
        super(context);
    }

    public WatermarkBelowView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View mBaseView = LayoutInflater.from(context).inflate(R.layout.below_layout, this, true);
        ll_text_size = mBaseView.findViewById(R.id.ll_text_size);
        ll_input = mBaseView.findViewById(R.id.ll_input);
        ll_paint_color = mBaseView.findViewById(R.id.ll_paint_color);
        fl_item = mBaseView.findViewById(R.id.fl_item);
        et_input = mBaseView.findViewById(R.id.et_input);
        sb_text_size = mBaseView.findViewById(R.id.sb_text_size);
        setUnVisi();
        setColorData(context);
    }

    public void setTextSizeVisi(int postion) {
        setVisibility(VISIBLE);
        for (int i = 0; i < fl_item.getChildCount(); i++) {
            if (postion == i) {
                fl_item.getChildAt(i).setVisibility(VISIBLE);
            } else {
                fl_item.getChildAt(i).setVisibility(GONE);
            }
        }
    }

    public void setUnVisi() {
        setVisibility(GONE);
    }

    public String getEditText() {
        return et_input.getText().toString();
    }

    public void setEditNull() {
        et_input.setText("");
    }


    private void setColorData(Context context) {
        int[] intArray = getResources().getIntArray(R.array.color_array);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(120, 150);
        for (int i = 0; i < intArray.length; i++) {
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams);
            textView.setBackgroundColor(intArray[i]);
            ll_paint_color.addView(textView);
            textView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onBelowColor != null) {
                        TextView textView = (TextView) view;
                        ColorDrawable colorDrawable = (ColorDrawable) textView.getBackground();
                        if (onBelowColor != null) {
                            onBelowColor.onGetColor(colorDrawable.getColor());
                        }
                    }
                }
            });
        }
    }


    public void setOnBelowListener(OnWaterInterface onBelowColor) {
        this.onBelowColor = onBelowColor;
    }

}
