package com.example.aidlservercomponent;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.aidlclientcomponent.MyAidlInterface;

public class AidlServerService extends Service {

    private static final String TAG = "AidlServerService";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyAidlInterface.Stub() {
            @Override
            public int add(int x, int y) throws RemoteException {
                Log.d(TAG, "X=" + x + ";Y=" + y);
                return 0;
            }
        };
    }

}
