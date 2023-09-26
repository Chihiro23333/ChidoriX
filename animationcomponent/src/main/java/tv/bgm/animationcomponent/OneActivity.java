package tv.bgm.animationcomponent;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

/**
 * Created by Chihiro on 2018/7/24.
 */
public class OneActivity extends AppCompatActivity implements View.OnClickListener {

    private View anim_view;

    private Button bt_scale;
    private Button bt_alpha;
    private Button bt_rotate;
    private Button bt_trans;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_one);

        anim_view = findViewById(R.id.anim_view);
        bt_scale = findViewById(R.id.bt_scale);
        bt_alpha = findViewById(R.id.bt_alpha);
        bt_rotate = findViewById(R.id.bt_rotate);
        bt_trans = findViewById(R.id.bt_trans);

        bt_scale.setOnClickListener(this);
        bt_alpha.setOnClickListener(this);
        bt_trans.setOnClickListener(this);
        bt_rotate.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        anim_view.setVisibility(View.VISIBLE);
        switch (view.getId()) {
            case R.id.bt_scale:
                anim_view.startAnimation(getAnimation(R.anim.animation_scale_anim));
                break;
            case R.id.bt_alpha:
                anim_view.startAnimation(getAnimation(R.anim.animation_alpha_anim));
                break;
            case R.id.bt_rotate:
                anim_view.startAnimation(getAnimation(R.anim.animation_rotate_anim));
                break;
            case R.id.bt_trans:
                anim_view.startAnimation(getAnimation(R.anim.animation_translate_anim));
                break;
        }
    }

    private Animation getAnimation(int animation) {
        Animation animation1 = AnimationUtils.loadAnimation(OneActivity.this, animation);
        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                anim_view.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        return animation1;
    }
}
