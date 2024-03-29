package com.bilibili.diyroutercomponent;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.bilbili.diyrouter_annotation_api.ButterKnife;
import com.bilibili.diyrouter_annotation.annotation.BindView;
import com.bilibili.diyrouter_annotation.annotation.Explain;
import com.luojilab.component.basicres.BaseActivity;
import com.luojilab.router.facade.annotation.RouteNode;

@Explain(desc = "这是diyroutercomponent的入口")
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
