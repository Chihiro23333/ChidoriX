package com.bilibili.threadcomponent.threadpermessage.executorsample;

import java.util.concurrent.Executor;

public class Host {

    private Helper helper;
    private Executor executor;

    public Host(Executor executor) {
        this.executor = executor;
        helper = new Helper();
    }

    public void request(final int count, final char desc) {
        System.out.println("   " + "BEGIN:request");
        executor.execute(new Runnable() {
            @Override
            public void run() {
                helper.handle(count, desc);
            }
        });
        System.out.println("   " + "END:request");
    }
}
