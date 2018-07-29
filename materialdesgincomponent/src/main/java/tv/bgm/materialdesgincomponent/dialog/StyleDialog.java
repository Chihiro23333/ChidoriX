package tv.bgm.materialdesgincomponent.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import tv.bgm.materialdesgincomponent.R;

/**
 * Created by Chihiro on 2018/7/26.
 */

public class StyleDialog extends Dialog {
    public StyleDialog(@NonNull Context context) {
        this(context ,0);
    }

    public StyleDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.material_desgin_material_dialog_style);

        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT ,ViewGroup.LayoutParams.MATCH_PARENT );
    }
}
