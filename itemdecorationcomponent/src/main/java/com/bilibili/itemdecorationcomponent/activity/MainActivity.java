package com.bilibili.itemdecorationcomponent.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.GridLayoutManager;
import androidx.appcompat.widget.LinearLayoutManager;
import androidx.appcompat.widget.OrientationHelper;
import androidx.appcompat.widget.RecyclerView;
import androidx.appcompat.widget.StaggeredGridLayoutManager;

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
