package com.bilibili.threadcomponent.worker.sample;

import java.util.Random;

public class Request {
    private int num;
    private String name;
    private Random random = new Random();

    public Request(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public void execute(){
        System.out.println(Thread.currentThread().getName()+"execute name:"+name+" num:"+num);
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
