package com.bilibili.threadcomponent.threadpermessage.scheduledexecutorservicesample;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Host {

    private Helper helper;
    private ScheduledExecutorService scheduledExecutorService;

    public Host(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorService = scheduledExecutorService;
        helper = new Helper();
    }

    public void request(final int count, final char desc) {
        System.out.println("   " + "BEGIN:request");
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                helper.handle(count, desc);
            }
        },5000 , TimeUnit.MILLISECONDS);
        System.out.println("   " + "END:request");
    }
}
