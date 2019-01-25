package com.bilibili.threadcomponent.singlethreadexecution.semaphore;

import java.util.concurrent.Semaphore;

public class BoundedResource {

    private final Semaphore semaphore;
    private final int permits;

    public BoundedResource(int permits) {
        this.semaphore = new Semaphore(permits);
        this.permits = permits;
    }

    public void use() throws InterruptedException {
        semaphore.acquire();
        try {
            doUse();
        } finally {
            semaphore.release();
        }
    }

    private void doUse() throws InterruptedException {
        System.out.println("USED=" + (permits - semaphore.availablePermits()) + Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("USED=" + (permits - semaphore.availablePermits()) + Thread.currentThread().getName());
    }
}
