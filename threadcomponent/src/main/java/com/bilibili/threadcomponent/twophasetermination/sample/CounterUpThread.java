package com.bilibili.threadcomponent.twophasetermination.sample;

public class CounterUpThread extends Thread {

    private int count;
    private volatile boolean isShutDownRequest = false;

    public void showDownRequest() {
        isShutDownRequest = true;
        interrupt();
    }

    private boolean isShutDownRequest() {
        return isShutDownRequest;
    }

    @Override
    public void run() {
        super.run();
        try {
            while (!isShutDownRequest()) {
                doWork();
            }
        } catch (InterruptedException e) {
        } finally {
            doShutDown();
        }
    }

    private void doShutDown() {
        System.out.println("doShutDown");
    }

    private void doWork() throws InterruptedException {
        System.out.println("doWork:count=" + count);
        count++;
        Thread.sleep(500);
    }

}
