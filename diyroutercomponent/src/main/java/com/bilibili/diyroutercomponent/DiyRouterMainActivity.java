package com.bilibili.diyroutercomponent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;

import com.bilbili.diyrouter_annotation_api.ButterKnife;
import com.bilibili.diyrouter_annotation.annotation.BindView;
import com.luojilab.component.basicres.BaseActivity;
import com.luojilab.router.facade.annotation.RouteNode;

@RouteNode(path = "/diyRouter",desc="手撸简单Router")
public class DiyRouterMainActivity extends BaseActivity {

    @BindView(R.id.tv_name)
    AppCompatTextView tv_name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diyrouter_act_diy_router_main);

        ButterKnife.bind(this);

        tv_name.setText("binview success!");
    }
}
