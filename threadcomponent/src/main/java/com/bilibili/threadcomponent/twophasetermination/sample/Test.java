package com.bilibili.threadcomponent.twophasetermination.sample;

public class Test {

    public static void main(String args[]) {
        System.out.println("MAIN:BEGIN");
        try {
            CounterUpThread t = new CounterUpThread();
            t.start();

            Thread.sleep(5000);

            System.out.println("showDownRequest");
            t.showDownRequest();

            System.out.println("join");
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MAIN:END");
    }

}
