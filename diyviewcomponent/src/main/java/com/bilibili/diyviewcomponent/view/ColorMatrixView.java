package com.bilibili.diyviewcomponent.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.bilibili.diyviewcomponent.R;

/**
 * Created by Chihiro on 2018/7/25.
 */

public class ColorMatrixView extends View {

    private Paint mPaint;
    private Bitmap bitmap;

    public ColorMatrixView(Context context) {
        this(context ,null);
    }

    public ColorMatrixView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs ,0);
    }

    public ColorMatrixView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setARGB(255 ,200 ,100 ,100);

        bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.test);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        canvas.drawRect(0 ,0 ,500 ,500 ,mPaint);
//
//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                0,0,0,0,0,
//                0,0,0,0,0,
//                0,0,1,0,0,
//                0,0,0,1,0
//        });
//        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
//        canvas.drawRect(500,500,800,800 ,mPaint);


        canvas.drawBitmap(bitmap ,null ,new Rect(0,0,1000, 1000 * bitmap.getHeight() / bitmap.getWidth()),mPaint);

        canvas.translate(0 ,1000 * bitmap.getHeight() / bitmap.getWidth() +100);
//保留蓝色
//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                0,0,0,0,0,
//                0,0,0,0,0,
//                0,0,1,0,0,
//                0,0,0,1,0
//        });
        //增强某个颜色
//                ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                1,0,0,0,0,
//                0,1,0,0,100,
//                0,0,1,0,0,
//                0,0,0,1,0
//        });
                //色彩反转/反相功能,色彩反转就是求出每个色彩的补值来做为目标图像的对应颜色值：

//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                -1,0,0,0,255,
//                0,-1,0,0,255,
//                0,0,-1,0,255,
//                0,0,0,1,0
//        });

//        色彩的缩放运算
//        我们可以针对某一个颜色值进行放大缩小运算，但当对R、G、B、A同时进行放大缩小时，就是对亮度进行调节！
//        看下面的将亮度增大1.2倍的代码：

        //setSaturation

//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                1.2f,0,0,0,0,
//                0,1.2f,0,0,0,
//                0,0,1.2f,0,0,
//                0,0,0,1.2f,0
//        });

//        色彩投射的一个最简单应用就是变为黑白图片：
//        首先了解一下去色原理：只要把RGB三通道的色彩信息设置成一样；即：R＝G＝B，那么图像就变成了灰色，并且，为了保证图像亮度不变，同一个通道中的R+G+B=1:如：0.213+0.715+0.072＝1；
//        三个数字的由来：0.213, 0.715, 0.072；
//        按理说应该把RGB平分，都是0.3333333。三个数字应该是根据色彩光波频率及色彩心理学计算出来的（本人是这么认为，当然也查询了一些资料，目前尚未找到准确答案）。
//        在作用于人眼的光线中，彩色光要明显强于无色光。对一个图像按RGB平分理论给图像去色的话，人眼就会明显感觉到图像变暗了（当然可能有心理上的原因，也有光波的科学依据）另外，在彩色图像中能识别的一下细节也可能会丢失。
//        所以google最终给我们的颜色值就是上面的比例：0.213, 0.715, 0.072；
//        所以，在给图像去色时我们保留了大量的G通道信息，使得图像不至于变暗或者绿色信息不至于丢失（我猜想）。

//                ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                0.213f,0.715f,0.072f,0,0,
//                        0.213f,0.715f,0.072f,0,0,
//                        0.213f,0.715f,0.072f,0,0,
//                        0.213f,0.715f,0.072f,1.2f,0
//        });

                //色彩反色
//        当我们利用色彩矩阵将两个颜色反转，这种操作就叫做色彩反色
//        比如，下面的的将红色和绿色反色（红绿反色）


//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                0,1,0,0,0,
//                1,0,0,0,0,
//                0,0,1,0,0,
//                0,0,0,1,0
//        });

        //变旧照片


        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                1/2f,1/2f,1/2f,0,0,
                1/3f,1/3f,1/3f,0,0,
                1/4f,1/4f,1/4f,0,0,
                0,0,0,1,0
        });

        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap ,null ,new Rect(0,0,1000, 1000 * bitmap.getHeight() / bitmap.getWidth()),mPaint);
    }
}
