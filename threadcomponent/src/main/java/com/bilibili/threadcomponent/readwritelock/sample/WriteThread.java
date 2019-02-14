package com.bilibili.threadcomponent.readwritelock.sample;

import java.util.Random;

public class WriteThread extends Thread {

    private Data data;
    private int index = 0;
    private String str;
    private Random random;

    public WriteThread(Data data, String str) {
        this.data = data;
        this.str = str;
        random = new Random();
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            try {
                data.write(str.charAt(index % str.length()));
                index++;
                Thread.sleep(random.nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
