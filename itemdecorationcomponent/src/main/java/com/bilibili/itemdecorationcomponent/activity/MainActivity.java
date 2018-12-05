package com.bilibili.itemdecorationcomponent.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.bilibili.itemdecorationcomponent.R;
import com.bilibili.itemdecorationcomponent.adapter.SampleAdapter;
import com.bilibili.itemdecorationcomponent.itemdecoration.SampleItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;

    private List<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);

        initRv();
    }

    private void initRv() {

        datas = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            datas.add("item" + i);
        }

        rv.setLayoutManager(new StaggeredGridLayoutManager(2 , OrientationHelper.VERTICAL));
        rv.setAdapter(new SampleAdapter(datas, MainActivity.this));
        rv.addItemDecoration(new SampleItemDecoration());
    }
}
