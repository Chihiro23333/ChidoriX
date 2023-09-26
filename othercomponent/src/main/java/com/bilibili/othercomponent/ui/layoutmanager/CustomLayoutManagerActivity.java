package com.bilibili.othercomponent.ui.layoutmanager;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bilibili.othercomponent.R;
import com.bilibili.othercomponent.ui.constant.Constant;

import java.util.ArrayList;
import java.util.List;

public class CustomLayoutManagerActivity extends AppCompatActivity {

    private RecyclerView rv;

    private List<String> datas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_custom_layout_manager);

        findView();

        initData();

        initRecyclerView();
    }

    private void initData() {
        datas = new ArrayList<>();
        datas.add("全职猎人");
        datas.add("妖狐小红狼");
        datas.add("刻刻");
        datas.add("龙与虎");
        datas.add("火影");
        datas.add("One Piece");
        datas.add("我的青春恋爱物语果然有问");
        datas.add("刀剑神域序列之争");
        datas.add("死亡笔记");
        datas.add("命运石之门");
        datas.add("钢之炼金术师");
        datas.add("龙猫");
    }

    private void initRecyclerView() {
        rv.setLayoutManager(new PickerLayoutManager(this,rv, PickerLayoutManager.HORIZONTAL, false,3,0.4f,true));
        rv.setAdapter(new ItemAdapter(datas));
//        rv.setLayoutManager(new FlowLayoutManager());
    }


    private void findView() {
        rv = findViewById(R.id.rv);
    }

    private class ItemAdapter extends RecyclerView.Adapter {

        private List<String> datas;

        public ItemAdapter(List<String> datas) {
            this.datas = datas;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Log.i(Constant.TAG, "onCreateViewHolder");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.other_item_layoutmanager, parent, false);
            return new ItemViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Log.i(Constant.TAG, "onBindViewHolder");
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.tv_item.setText(datas.get(position));
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        private class ItemViewHolder extends RecyclerView.ViewHolder {

            private TextView tv_item;

            public ItemViewHolder(View itemView) {
                super(itemView);
                tv_item = itemView.findViewById(R.id.tv_item);
            }
        }
    }
}
