package com.bilbili.diyrouter_annotation_api;

import android.app.Activity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chihiro on 2018/7/4.
 */

public class ButterKnife {
    private static final ActivityFinder finder = new ActivityFinder();
    private static Map<String, Injector> FINDER_MAP = new HashMap<>();

    public static void bind(Activity activity) {
        bind(activity, activity);
    }

    private static void bind(Object host, Object source) {
        bind(host, source, finder);
    }

    private static void bind(Object host, Object source, Finder finder) {
        String className = host.getClass().getName();
        try {
            Injector injector = FINDER_MAP.get(className);
            if (injector == null) {
                Class<?> finderClass = Class.forName(className + "$$Injector");
                injector = (Injector) finderClass.newInstance();
                FINDER_MAP.put(className, injector);
            }
            injector.inject(host, source, finder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
