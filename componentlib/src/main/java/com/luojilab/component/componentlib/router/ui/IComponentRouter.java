package com.luojilab.component.componentlib.router.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * router behaviors for component type
 * Created by mrzhang on 2017/6/20.
 */
public interface IComponentRouter {

    boolean openUri(Context context, String url, Bundle bundle);

    boolean openUri(Context context, Uri uri, Bundle bundle);

    boolean openUri(Context context, String url, Bundle bundle, Integer requestCode);

    boolean openUri(Context context, Uri uri, Bundle bundle, Integer requestCode);

    /**
     * use {@link #verifyUri(Uri, Bundle, boolean)} instead
     * @param uri the uri to be verified
     * @return true if sth accept it
     */
    @Deprecated

    boolean verifyUri(Uri uri);

    @NonNull
    VerifyResult verifyUri(Uri uri, Bundle bundle, boolean checkParams);
}