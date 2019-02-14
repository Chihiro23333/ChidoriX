package com.bilibili.threadcomponent.threadpermessage.sample;

public class Host {
    Helper helper;

    public Host() {
        helper = new Helper();
    }

    public void request(final int count, final char desc) {
        System.out.println("   "  + "BEGIN:request");
        new Thread(new Runnable() {
            @Override
            public void run() {
                helper.handle(count, desc);
            }
        }).start();
        System.out.println("   "+ "END:request");
    }
}
