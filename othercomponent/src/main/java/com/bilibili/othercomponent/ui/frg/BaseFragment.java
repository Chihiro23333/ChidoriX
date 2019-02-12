package com.bilibili.othercomponent.ui.frg;

import android.animation.Animator;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

import com.bilibili.othercomponent.R;

import java.lang.reflect.Field;

public class BaseFragment extends Fragment {

    private static final String TAG = "BaseFragment";

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        Log.i(TAG, "onCreateAnimation" + "transit=" + transit + "enter=" + enter + "nextAnim=" + nextAnim);

        if (transit == FragmentTransaction.TRANSIT_FRAGMENT_OPEN) {
            if (enter) {
                return AnimationUtils.loadAnimation(getActivity(), R.anim.slide_right_in);
            } else {
                return AnimationUtils.loadAnimation(getActivity(), R.anim.slide_right_out);
            }
        } else if (transit == FragmentTransaction.TRANSIT_FRAGMENT_CLOSE) {
            if (enter) {
                return AnimationUtils.loadAnimation(getActivity(), R.anim.slide_left_in);
            } else {
                return AnimationUtils.loadAnimation(getActivity(), R.anim.slide_right_out);
            }
        } else {
            if ((getTag() != null && getTag().startsWith("android:switcher:") && getUserVisibleHint()) ||
                    (getParentFragment() != null && getParentFragment().isRemoving() && !isHidden())) {
                Animation animation = new Animation() {
                };
                animation.setDuration(300);
                return animation;
            }
        }
        return null;
    }
}
