package com.bilibili.threadcomponent.readwritelock.sample;

public class Data {
    private char[] buffer;
    private ReadWriteLock lock;

    public Data() {
        this.buffer = new char[10];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = '*';
        }
        this.lock = new ReadWriteLock();
    }

    public char[] read() throws InterruptedException {
        lock.readLock();
        try {
            return doRead();
        } finally {
            lock.readUnLock();
        }
    }

    public void write(char c) throws InterruptedException {
        lock.writeLock();
        try {
            doWrite(c);
        } finally {
            lock.writeUnLock();
        }
    }

    private void doWrite(char c) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
            slowly();
        }
        System.out.println(Thread.currentThread().getName() + ":doWrite" + "char=" + c);
    }

    private char[] doRead() {
        char[] newBuff = new char[10];
        for (int i = 0; i < buffer.length; i++) {
            newBuff[i] = buffer[i];
        }
        System.out.println(Thread.currentThread().getName() + ":doRead");
        slowly();
        return newBuff;
    }

    private void slowly() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
