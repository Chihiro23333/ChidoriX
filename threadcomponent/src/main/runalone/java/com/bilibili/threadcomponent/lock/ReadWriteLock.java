package com.bilibili.threadcomponent.lock;

public class ReadWriteLock {

    private int reading = 0;
    private int writing = 0;
    private int waitingWrite = 0;
    private boolean preferWrite = true;

    public synchronized void readLock() {
        System.out.println(Thread.currentThread().getName() + ":BEGIN:readLock");
        while (writing > 0 || (preferWrite && waitingWrite > 0)) {
            try {
                System.out.println(Thread.currentThread().getName() + "readLock:wait");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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

    public synchronized void writeLock() {
        System.out.println(Thread.currentThread().getName() + ":BEGIN:writeLock");
        waitingWrite++;
        try {
            while (writing > 0 || reading > 0) {
                System.out.println(Thread.currentThread().getName() + "writeLock:wait");
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
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
