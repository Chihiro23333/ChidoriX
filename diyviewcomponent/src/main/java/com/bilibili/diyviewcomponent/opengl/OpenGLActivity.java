package com.bilibili.diyviewcomponent.opengl;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bilibili.diyviewcomponent.R;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * @author 朱峰 2019/5/27
 */
public class OpenGLActivity extends AppCompatActivity {

    private GLSurfaceView gls;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diyview_act_opengl);

        gls = findViewById(R.id.gls);
        gls.setEGLContextClientVersion(2);
        gls.setRenderer(new MyRender());
        gls.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
    }
}
