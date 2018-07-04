package com.bilbili.diyrouter_annotation_api;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/**
 * Created by Chihiro on 2018/7/4.
 */

public class ActivityFinder implements Finder {
    @Override
    public Context getContext(Object source) {
        return (Activity)source;
    }

    @Override
    public View findView(Object source, int id) {
        return ((Activity)source).findViewById(id);
    }
}
