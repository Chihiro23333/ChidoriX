package com.bilbili.diyrouter_annotation_api;

/**
 * Created by Chihiro on 2018/7/4.
 */

public interface Injector<T> {
    void inject(T host ,Object object ,Finder finder);
}
