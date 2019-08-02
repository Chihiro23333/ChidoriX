package com.bilibili.diyviewcomponent.watermark;

import android.graphics.Bitmap;

/**
 * @author 朱峰 2019/5/30
 */
public interface EditableWatermark {

    int TYPE_IMG = 0;
    int TYPE_TEXT = 1;

    //0-1
    void setWatermarkAlpha(float alpha);

    //sp
    void setWatermarkTextSize(int textSize);

    //颜色resid
    void setWatermarkTextColor(int color);

    void setWatermarkImageSource(String path);

    void setWatermarkImageBitmap(Bitmap bitmap);

    void setWatermarkText(String text);

    float getLeftRelativeToWidth();

    float getRightRelativeToWidth();

    float getTopRelativeToHeight();

    float getBottomRelativeToHeight();

    Bitmap getBitmap();

    float getWatermarkAlpha();

    int getType();
}
