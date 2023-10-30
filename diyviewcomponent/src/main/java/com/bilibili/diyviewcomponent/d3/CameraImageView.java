package com.bilibili.diyviewcomponent.d3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.bilibili.diyviewcomponent.R;

public class CameraImageView extends AppCompatImageView {

    private Camera camera = new Camera();
    private Paint paint = new Paint();
    private int progress;

    public CameraImageView(@NonNull Context context) {
        this(context, null);
    }

    public CameraImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CameraImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint.setAntiAlias(true);
    }


    public void setProgress(int progress) {
        this.progress = progress;
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        camera.save();

        camera.rotateY(progress);
        camera.applyToCanvas(canvas);

        camera.restore();
        super.onDraw(canvas);
        canvas.restore();
    }
}
