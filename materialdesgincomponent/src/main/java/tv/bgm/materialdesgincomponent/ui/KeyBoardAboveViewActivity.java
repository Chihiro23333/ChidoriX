package tv.bgm.materialdesgincomponent.ui;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import tv.bgm.materialdesgincomponent.R;
import tv.bgm.materialdesgincomponent.utils.DisplayUtil;

public class KeyBoardAboveViewActivity extends AppCompatActivity {

    private ScrollView sv;
    private LinearLayout ll_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_desgin_material_act_keyboard_above_view);

        sv = findViewById(R.id.sv);
        ll_content = findViewById(R.id.ll_content);

        ViewGroup.LayoutParams layoutParams = sv.getLayoutParams();
        layoutParams.height = DisplayUtil.getScreenHeight(KeyBoardAboveViewActivity.this) / 3;
        sv.setLayoutParams(layoutParams);

        ViewGroup.LayoutParams layoutParams1 = ll_content.getLayoutParams();
        layoutParams1.height = DisplayUtil.getScreenHeight(KeyBoardAboveViewActivity.this) / 3;
        ll_content.setLayoutParams(layoutParams1);

    }
}
