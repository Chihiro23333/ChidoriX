package com.bilibili.threadcomponent.twophasetermination.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {

    private CountDownLatch countDownLatch;
    private int context;

    public Task(CountDownLatch countDownLatch, int context) {
        this.countDownLatch = countDownLatch;
        this.context = context;
    }

    @Override
    public void run() {
        doTask();
        countDownLatch.countDown();
    }

    private void doTask() {
        System.out.println("doTask:BEGIN=" + context);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("doTask:END=" + context);
        }
    }

}
