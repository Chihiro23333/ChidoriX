package com.bilibili.threadcomponent.producerconsumer.sample;

import java.util.Random;

public class EaterThread extends Thread {

    private final Table table;
    private Random random = new Random();

    public EaterThread(String name, Table table) {
        super(name);
        this.table = table;
    }

    @Override
    public void run() {
        super.run();
        while (true){
            table.get();
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
