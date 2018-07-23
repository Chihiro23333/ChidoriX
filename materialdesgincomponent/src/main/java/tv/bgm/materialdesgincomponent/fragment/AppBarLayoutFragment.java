package tv.bgm.materialdesgincomponent.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import tv.bgm.materialdesgincomponent.R;

/**
 * Created by Chihiro on 2018/7/20.
 */

public class AppBarLayoutFragment extends Fragment {

    private ViewPager vp;

    private List<Fragment> fragments;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.material_desgin_frg_app_bar_layout_viewpager ,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vp = view.findViewById(R.id.vp);

        fragments = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            fragments.add(new ScrollFragment());
        }

        vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
    }
}
