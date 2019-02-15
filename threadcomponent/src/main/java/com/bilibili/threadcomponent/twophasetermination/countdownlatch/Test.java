package com.bilibili.threadcomponent.twophasetermination.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    private static int TASKS = 10;

    public static void main(String args[]) {

        System.out.println("main:BEGIN");

        ExecutorService executorService = Executors.newFixedThreadPool(TASKS / 2);

        CountDownLatch countDownLatch = new CountDownLatch(TASKS);
        try {
            for (int i = 0; i < TASKS; i++) {
                executorService.execute(new Task(countDownLatch, i));
            }
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main:END");
    }

}
