package com.bilibili.threadcomponent.readwritelock.sample;

public class Test {

    public static void main(String args[]) {
        Data data = new Data();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new WriteThread(data,"ABCDEFGHIJKLMN").start();
        new WriteThread(data, "abcdefghijklmn").start();
    }

}
