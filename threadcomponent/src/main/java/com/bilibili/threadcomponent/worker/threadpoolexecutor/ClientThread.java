package com.bilibili.threadcomponent.worker.threadpoolexecutor;

import java.util.Random;
import java.util.concurrent.Executor;

public class ClientThread extends Thread{

    private Executor executor;
    private String name;
    private Random random = new Random();

    public ClientThread(String name, Executor executor){
        this.name = name;
        this.executor = executor;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; true; i++) {
            Request request = new Request(i ,name);
            executor.execute(request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
