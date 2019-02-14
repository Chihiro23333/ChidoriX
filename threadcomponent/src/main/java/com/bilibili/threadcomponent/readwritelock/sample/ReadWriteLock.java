package com.bilibili.threadcomponent.readwritelock.sample;

public class ReadWriteLock {

    private int reading = 0;
    private int writing = 0;
    private int waitingWrite = 0;
    private boolean preferWrite = true;

    public synchronized void readLock() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + ":BEGIN:readLock");
        while (writing > 0 || (preferWrite && waitingWrite > 0)) {
            System.out.println(Thread.currentThread().getName() + "readLock:wait");
            wait();
        }
        reading++;
        System.out.println(Thread.currentThread().getName() + ":END:readLock");
    }

    public synchronized void readUnLock() {
        System.out.println(Thread.currentThread().getName() + ":BEGIN:readUnLock");
        reading--;
        preferWrite = true;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + ":END:readUnLock");
    }

    public synchronized void writeLock() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + ":BEGIN:writeLock");
        waitingWrite++;
        try {
            while (writing > 0 || reading > 0) {
                System.out.println(Thread.currentThread().getName() + "writeLock:wait");
                wait();
            }
        } finally {
            System.out.println(Thread.currentThread().getName() + "waitingWrite--");
            waitingWrite--;
        }
        writing++;
        System.out.println(Thread.currentThread().getName() + ":END:writeLock");
    }

    public synchronized void writeUnLock() {
        System.out.println(Thread.currentThread().getName() + ":BEGIN:writeUnLock");
        writing--;
        preferWrite = false;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + ":END:writeUnLock");
    }

}
