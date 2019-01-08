package com.bilibili.othercomponent.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bilibili.othercomponent.R;

import java.util.ArrayList;
import java.util.List;

public class TestFragment extends Fragment {

    private Button bt_next;
    private int index;
    private String name;
    private ViewPager vp;

    public static TestFragment newInstance(int index) {
        TestFragment fragment = new TestFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        fragment.setArguments(bundle);
        return fragment;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.other_test_fragment, null);
        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bt_next = view.findViewById(R.id.bt_next);
        vp = view.findViewById(R.id.vp);

        Bundle arguments = getArguments();
        index = arguments.getInt("index");

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTestFragmentActivity().addFragment(TestFragment.newInstance(index + 1));
            }
        });

        final List<Fragment> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            TestFragmentB e = new TestFragmentB();
            e.setType(i);
            list.add(e);
        }

        vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }

    private TestFragmentActivity getTestFragmentActivity() {
        return (TestFragmentActivity) getActivity();
    }
}
