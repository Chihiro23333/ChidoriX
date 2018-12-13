package com.bilibili.diyviewcomponent.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.bilibili.diyviewcomponent.R;
import com.bilibili.diyviewcomponent.util.Utils;
import com.luojilab.router.facade.annotation.RouteNode;

@RouteNode(path = "/diyViewMain", desc = "自定义控件学习")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View one;
    private View two;
    private View three;
    private View four;
    private View five;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diyview_act_diy_view_main);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five =findViewById(R.id.five);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);

        Log.i("eee", Utils.getStatusBarHeight(MainActivity.this) + "");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.one:
                Jump(DiyViewOneActivity.class);
                break;
            case R.id.two:
                Jump(DiyViewTwoActivity.class);
                break;
            case R.id.three:
                Jump(DiyViewThreeActivity.class);
                break;
            case R.id.four:
                Jump(ShapeActivity.class);
                break;
            case R.id.five:
                Jump(MultiTouchActivity.class);
                break;
        }
    }

    private void Jump(Class<?> c) {
        Intent intent = new Intent(MainActivity.this, c);
        startActivity(intent);
    }
}
