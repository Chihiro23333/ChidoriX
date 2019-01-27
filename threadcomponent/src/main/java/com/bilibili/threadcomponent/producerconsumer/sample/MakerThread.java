package com.bilibili.threadcomponent.producerconsumer.sample;

import java.util.Random;

public class MakerThread extends Thread {

    private final Table table;
    private Random random = new Random();
    private static int id = 0;

    public MakerThread(String name, Table table) {
        super(name);
        this.table = table;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            table.put("NO." + nextId()+"maked by "+getName());
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static synchronized int nextId() {
        return id++;
    }
}
