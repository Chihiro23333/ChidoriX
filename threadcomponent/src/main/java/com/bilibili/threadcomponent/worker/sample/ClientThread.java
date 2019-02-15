package com.bilibili.threadcomponent.worker.sample;

import java.util.Random;

public class ClientThread extends Thread{

    private final Channel channel;
    private String name;
    private Random random = new Random();

    public ClientThread(String name, Channel channel){
        this.name = name;
        this.channel = channel;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; true; i++) {
            Request request = new Request(i ,name);
            channel.putRequest(request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
