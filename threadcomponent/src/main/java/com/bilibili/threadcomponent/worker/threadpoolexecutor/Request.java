package com.bilibili.threadcomponent.worker.threadpoolexecutor;

import java.util.Random;

public class Request implements Runnable{
    private int num;
    private String name;
    private Random random = new Random();

    public Request(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"execute name:"+name+" num:"+num);
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
