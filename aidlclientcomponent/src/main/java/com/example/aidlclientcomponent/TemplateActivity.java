package com.example.aidlclientcomponent;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TemplateActivity extends AppCompatActivity {

    private MyAidlInterface myAidlInterface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aidlclient_act_main);
    }

    public void bindService(View view){
        Intent intent = new Intent("aidl.intent.action.BIND");
        intent.setPackage("com.example.aidlservercomponent");
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                myAidlInterface = MyAidlInterface.Stub.asInterface(service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, Context.BIND_AUTO_CREATE);
    }

    public void add(View view){
        try {
            myAidlInterface.add(10,20);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
