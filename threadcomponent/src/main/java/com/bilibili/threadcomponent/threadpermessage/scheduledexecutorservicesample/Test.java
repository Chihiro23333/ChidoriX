package com.bilibili.threadcomponent.threadpermessage.scheduledexecutorservicesample;

import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Test {

    public static void main(String args[]) {
        System.out.println("MAIN BEGIN");
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        Host host = new Host(scheduledExecutorService);
        try {
            host.request(10, 'A');
            host.request(20, 'B');
            host.request(30, 'C');
        }finally {
            scheduledExecutorService.shutdown();
        }
        System.out.println("MAIN END");
    }

}
