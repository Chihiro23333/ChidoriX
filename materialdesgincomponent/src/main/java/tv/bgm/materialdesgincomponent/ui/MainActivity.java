package tv.bgm.materialdesgincomponent.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import tv.bgm.materialdesgincomponent.R;

/**
 * Created by Chihiro on 2018/7/17.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private View one;
    private View two;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_desgin_main);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.one:
                Jump(ToolBarActivity.class);
                break;
            case R.id.two:
                Jump(AppBarLayoutActivity.class);
                break;
        }
    }

    private void Jump(Class<?> c) {
        Intent intent = new Intent(MainActivity.this, c);
        startActivity(intent);
    }
}
