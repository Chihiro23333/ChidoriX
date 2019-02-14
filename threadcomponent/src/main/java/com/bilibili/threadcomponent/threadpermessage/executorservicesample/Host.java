package com.bilibili.threadcomponent.threadpermessage.executorservicesample;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class Host {

    private Helper helper;
    private ExecutorService executorService;

    public Host(ExecutorService executorService) {
        this.executorService = executorService;
        helper = new Helper();
    }

    public void request(final int count, final char desc) {
        System.out.println("   " + "BEGIN:request");
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                helper.handle(count, desc);
            }
        });
        System.out.println("   " + "END:request");
    }
}
