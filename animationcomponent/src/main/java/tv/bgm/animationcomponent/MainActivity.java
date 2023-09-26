package tv.bgm.animationcomponent;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Chihiro on 2018/7/24.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View bt_one;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.animation_main);

        bt_one = findViewById(R.id.bt_one);
        bt_one.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_one:
                Jump(OneActivity.class);
                break;
        }
    }

    private void Jump(Class<?> c) {
        Intent intent = new Intent(MainActivity.this, c);
        startActivity(intent);
    }
}
