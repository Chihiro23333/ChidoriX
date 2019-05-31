package com.bilibili.diyviewcomponent.watermark;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * @author 朱峰 2019/5/29
 */
public class TextWatermark extends FrameLayout implements EditableWatermark {

    private static final String TAG = "TextWatermark";

    private EditableWatermark watermark;
    private AppCompatTextView textView;

    public TextWatermark(Context context) {
        super(context);

        watermark = new ImageWatermark(context);
        textView = new AppCompatTextView(context);

        addView((View) watermark);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        addView(textView, layoutParams);
        textView.setVisibility(INVISIBLE);
    }

    @Override
    public void setWatermarkAlpha(float alpha) {
        watermark.setWatermarkAlpha(alpha);
    }

    @Override
    public void setWatermarkTextSize(int textSize) {

    }

    @Override
    public void setWatermarkTextColor(int color) {
        textView.setTextColor(color);
        updateBitmap();
    }

    @Override
    public void setWatermarkImageSource(String path) {

    }

    @Override
    public void setWatermarkImageBitmap(Bitmap bitmap) {

    }

    @Override
    public void setWatermarkText(final String text) {
        textView.setText(text);
        textView.setTextSize(40);
        textView.setTextColor(Color.YELLOW);

        updateBitmap();
    }

    @Override
    public int getType() {
        return TYPE_TEXT;
    }

    private void updateBitmap() {
        post(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "textvieww=" + textView.getWidth() + "textviewh=" + textView.getHeight());
                Bitmap bitmap = Bitmap.createBitmap(textView.getWidth(), textView.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                textView.draw(canvas);
                watermark.setWatermarkImageBitmap(bitmap);
            }
        });
    }
}
