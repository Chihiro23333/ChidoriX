package com.bilibili.threadcomponent.singlethreadexecution.semaphore;

public class UseThread extends Thread {

    private BoundedResource boundedResource;

    public UseThread(BoundedResource boundedResource) {
        this.boundedResource = boundedResource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                boundedResource.use();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
