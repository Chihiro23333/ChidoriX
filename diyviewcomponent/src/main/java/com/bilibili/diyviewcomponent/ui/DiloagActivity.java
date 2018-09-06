package com.bilibili.diyviewcomponent.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bilibili.diyviewcomponent.R;
import com.bilibili.diyviewcomponent.dialog.FullScreenDialog;

public class DiloagActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_full;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.diyview_act_dialog);

        bt_full = findViewById(R.id.bt_full);
        bt_full.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_full:
                showFullScreenDialog();
                break;
        }
    }

    private void showFullScreenDialog() {
        FullScreenDialog fullScreenDialog = new FullScreenDialog(DiloagActivity.this);
        fullScreenDialog.show();
    }
}
