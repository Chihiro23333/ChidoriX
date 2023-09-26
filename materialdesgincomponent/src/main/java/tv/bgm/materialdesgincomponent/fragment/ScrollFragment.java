package tv.bgm.materialdesgincomponent.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tv.bgm.materialdesgincomponent.R;

/**
 * Created by Chihiro on 2018/7/20.
 */

public class ScrollFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.material_desgin_frg_scroll ,null);
    }

}
