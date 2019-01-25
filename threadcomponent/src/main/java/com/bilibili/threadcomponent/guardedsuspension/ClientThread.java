package com.bilibili.threadcomponent.guardedsuspension;

import java.util.Random;

public class ClientThread extends Thread {
    private RequestQueue requestQueue;
    private Random random;

    public ClientThread(RequestQueue requestQueue, long seed) {
        this.requestQueue = requestQueue;
        random = new Random(seed);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            requestQueue.putRequest(new Request("request:" + i));
            System.out.println("put request" + i);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
