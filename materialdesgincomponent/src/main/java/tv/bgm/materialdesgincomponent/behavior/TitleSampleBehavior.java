package tv.bgm.materialdesgincomponent.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Chihiro on 2018/7/20.
 */

public class TitleSampleBehavior extends CoordinatorLayout.Behavior {

    private float deltaY;

    public TitleSampleBehavior() {
    }

    public TitleSampleBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {

        Log.i("eee","layoutDependsOn");

        return dependency instanceof NestedScrollView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {

        Log.i("eee","onDependentViewChanged");

//        if (deltaY == 0) {
//            deltaY = dependency.getY() - child.getHeight();
//        }
//
//        float dy = dependency.getY() - child.getHeight();
//        dy = dy < 0 ? 0 : dy;
//        float y = -(dy / deltaY) * child.getHeight();
//        child.setTranslationY(y);
        return true;
    }

    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, View child, int layoutDirection) {
        parent.onLayoutChild(child, layoutDirection);
        return true;
    }
}
