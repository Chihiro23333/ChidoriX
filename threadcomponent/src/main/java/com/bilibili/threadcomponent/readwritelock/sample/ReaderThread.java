package com.bilibili.threadcomponent.readwritelock.sample;

public class ReaderThread extends Thread {

    private Data data;

    public ReaderThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            try {
                char[] read = data.read();
                System.out.println(Thread.currentThread().getName() + ":" + String.valueOf(read));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
