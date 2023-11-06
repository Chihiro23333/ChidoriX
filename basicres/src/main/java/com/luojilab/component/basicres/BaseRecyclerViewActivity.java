package com.luojilab.component.basicres;

import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.annotation.Nullable;
import com.luojilab.component.basicres.databinding.CommonBaseRecyclerviewBinding;

public class BaseRecyclerViewActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CommonBaseRecyclerviewBinding binding = CommonBaseRecyclerviewBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
    }
}
