package com.bilibili.threadcomponent.guardedsuspension.talk;

import com.bilibili.threadcomponent.guardedsuspension.sample.Request;
import com.bilibili.threadcomponent.guardedsuspension.sample.RequestQueue;

public class TalkThread extends Thread {

    private final RequestQueue in;
    private final RequestQueue out;

    public TalkThread(RequestQueue in, RequestQueue out, String name) {
        super(name);
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        super.run();
        System.out.println(Thread.currentThread().getName() + "BEGIN:");

        for (int i = 0; i < 20; i++) {
            Request request = in.getRequest();
            System.out.println(Thread.currentThread().getName() + "int" + request);

            Request request1 = new Request(request.toString() + "!");
            out.putRequest(request1);
            System.out.println(Thread.currentThread().getName() + "out" + request1);
        }

        System.out.println(Thread.currentThread().getName() + "END:");
    }
}
