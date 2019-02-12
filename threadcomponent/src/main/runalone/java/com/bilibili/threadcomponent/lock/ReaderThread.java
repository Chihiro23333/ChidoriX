package com.bilibili.threadcomponent.lock;

public class ReaderThread extends Thread {

    private Data data;

    public ReaderThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            char[] read = data.read();
            System.out.println(String.valueOf(read));
        }
    }
}
