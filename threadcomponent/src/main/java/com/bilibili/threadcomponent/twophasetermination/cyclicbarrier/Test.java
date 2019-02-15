package com.bilibili.threadcomponent.twophasetermination.cyclicbarrier;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    private static final int THREADS = 3;
    private static final int MOST_PHASE = 3;

    public static void main(String args[]) {

        System.out.println("main:BEGIN");

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

        Runnable barrierAction = new Runnable() {
            @Override
            public void run() {
                System.out.println("barrierAction");
            }
        };

        CyclicBarrier cyclicBarrier = new CyclicBarrier(MOST_PHASE, barrierAction);
        CountDownLatch countDownLatch = new CountDownLatch(THREADS);

        try {
            for (int i = 0; i < THREADS; i++) {
                executorService.execute(new Task(cyclicBarrier, countDownLatch, i));
            }
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main:END");
    }

}
