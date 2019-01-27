package com.bilibili.threadcomponent.guardedsuspension.sample;

import java.util.Random;

public class ServerThread extends Thread {

    private RequestQueue requestQueue;
    private Random random;

    public ServerThread(RequestQueue requestQueue, long seed) {
        this.requestQueue = requestQueue;
        random = new Random(seed);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "handle:" + requestQueue.getRequest().toString());
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
