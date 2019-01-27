package com.bilibili.threadcomponent.balking.sample;

import java.util.Random;

public class ChangerThread extends Thread {

    private final Data data;
    private Random random = new Random();

    public ChangerThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 20; i++) {
            data.change("NO."+i);
            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.save();
        }
    }
}
