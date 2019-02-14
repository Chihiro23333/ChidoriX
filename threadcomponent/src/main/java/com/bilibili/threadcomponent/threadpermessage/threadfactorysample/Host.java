package com.bilibili.threadcomponent.threadpermessage.threadfactorysample;

import java.util.concurrent.ThreadFactory;

public class Host {

    private Helper helper;
    private ThreadFactory threadFactory;

    public Host(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
        helper = new Helper();
    }

    public void request(final int count, final char desc) {
        System.out.println("   " + "BEGIN:request");
        threadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                helper.handle(count, desc);
            }
        });
        System.out.println("   " + "END:request");
    }
}
