package com.bilibili.diyviewcomponent.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bilibili.diyviewcomponent.R;
import com.luojilab.router.facade.annotation.RouteNode;

@RouteNode(path = "/diyViewMain", desc = "自定义控件学习")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View one;
    private View two;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diyview_act_diy_view_main);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
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
        }
    }

    private void Jump(Class<?> c) {
        Intent intent = new Intent(MainActivity.this, c);
        startActivity(intent);
    }
}
