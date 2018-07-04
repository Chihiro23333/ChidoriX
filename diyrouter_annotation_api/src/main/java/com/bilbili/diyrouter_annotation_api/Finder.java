package com.bilbili.diyrouter_annotation_api;

import android.content.Context;
import android.view.View;

/**
 * Created by Chihiro on 2018/7/4.
 */

public interface Finder {

    Context getContext(Object source);

    View findView(Object source, int id);
}
