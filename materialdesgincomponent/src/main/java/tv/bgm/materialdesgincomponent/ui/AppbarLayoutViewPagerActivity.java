package tv.bgm.materialdesgincomponent.ui;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import tv.bgm.materialdesgincomponent.R;
import tv.bgm.materialdesgincomponent.fragment.AppBarLayoutFragment;

/**
 * Created by Chihiro on 2018/7/20.
 */

public class AppbarLayoutViewPagerActivity extends AppCompatActivity {

    private ViewPager vp;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_desgin_app_bar_layout_viewpager);

        vp = findViewById(R.id.vp);

        fragments = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            fragments.add(new AppBarLayoutFragment());
        }

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
