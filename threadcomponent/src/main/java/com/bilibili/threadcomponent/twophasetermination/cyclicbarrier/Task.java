package com.bilibili.threadcomponent.twophasetermination.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Task implements Runnable {

    private static final int PHASE = 5;

    private CyclicBarrier cyclicBarrier;
    private CountDownLatch countDownLatch;
    private int context;
    private Random random = new Random();

    public Task(CyclicBarrier cyclicBarrier, CountDownLatch countDownLatch, int context) {
        this.cyclicBarrier = cyclicBarrier;
        this.countDownLatch = countDownLatch;
        this.context = context;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < PHASE; i++) {
                doPhase(i);
                cyclicBarrier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }

    private void doPhase(int i) {
        System.out.println(Thread.currentThread().getName() + "doPhase:" + i + ":BEGIN:contxt=" + context);

        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "doPhase:" + i + ":END:contxt=" + context);
    }
}
