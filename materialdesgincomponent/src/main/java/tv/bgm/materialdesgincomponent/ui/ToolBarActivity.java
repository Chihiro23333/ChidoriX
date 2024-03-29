package tv.bgm.materialdesgincomponent.ui;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import tv.bgm.materialdesgincomponent.R;
import tv.bgm.materialdesgincomponent.dialog.StyleDialog;

/**
 * Created by Chihiro on 2018/7/17.
 */

public class ToolBarActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.material_desgin_toolbar);

        toolbar = findViewById(R.id.toolBar);

        toolbar.inflateMenu(R.menu.material_desgin_toolbar);

        StyleDialog styleDialog = new StyleDialog(ToolBarActivity.this);
        styleDialog.show();
    }
}
