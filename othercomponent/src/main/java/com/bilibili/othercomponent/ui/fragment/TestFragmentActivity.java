package com.bilibili.othercomponent.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.bilibili.othercomponent.R;
import com.bilibili.othercomponent.ui.activity.BaseActivity;

public class TestFragmentActivity extends BaseActivity {

    TestFragment testFragment = TestFragment.newInstance(0);
    TestFragment testFragment1 = TestFragment.newInstance(1);
    TestFragment testFragment2 = TestFragment.newInstance(2);

    private Button bt_add;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_act_test_fragment);

        bt_add = findViewById(R.id.bt_add);
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(testFragment);
                addFragment(testFragment1);
                addFragment(testFragment2);
            }
        });
    }

    private void initFragment() {

    }

    public void addFragment(final TestFragment fragment) {

        fragment.setName("adddddddddddddddddddddddddddddd");


        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.anim.slide_right_in,
                        R.anim.slide_left_out,
                        R.anim.slide_left_in,
                        R.anim.slide_right_out);
                ft.add(R.id.fl_container, fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
    }

    public void pop() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onBackPressed() {
        pop();
    }
}
