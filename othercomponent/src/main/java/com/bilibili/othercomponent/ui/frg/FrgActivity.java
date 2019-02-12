package com.bilibili.othercomponent.ui.frg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.bilibili.othercomponent.R;

public class FrgActivity extends AppCompatActivity {

    private TextView tv_add;
    private TextView tv_pop;
    private FrgFragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_act_frg);

        tv_add = findViewById(R.id.tv_add);
        tv_pop = findViewById(R.id.tv_pop);

        tv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_right_in ,R.anim.slide_right_out,
                        R.anim.slide_left_in ,R.anim.slide_left_out);
                fragment = new FrgFragment();
                fragmentTransaction.add(R.id.fl_container , fragment);
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.commit();
            }
        });

        tv_pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.setCustomAnimations(R.anim.slide_right_in ,R.anim.slide_right_out,
//                        R.anim.slide_left_in ,R.anim.slide_left_out);
//                fragmentTransaction.remove(fragment).commit();
                getSupportFragmentManager().popBackStack();
            }
        });
    }
}
