package com.bilibili.threadcomponent.threadpermessage.threadfactorysample;

import android.support.annotation.NonNull;

import java.util.concurrent.ThreadFactory;

public class Test {

    public static void main(String args[]) {
        System.out.println("MAIN BEGIN");
        Host host = new Host(new ThreadFactory() {
            @Override
            public Thread newThread(@NonNull Runnable r) {
                return new Thread(r);
            }
        });
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');
        System.out.println("MAIN END");
    }

}
