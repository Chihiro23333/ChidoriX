package com.bilibili.threadcomponent.twophasetermination.sample1;

public class Test {

    public static void main(String args[]){

        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("uncaughtException:BEGIN");
                System.out.println(Thread.currentThread().getName()+"----");
                System.out.println(t.getName()+"****");
                System.out.println("uncaughtException:END");
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("addShutdownHook:BEGIN");
                System.out.println(Thread.currentThread().getName()+"----");
                System.out.println("addShutdownHook:END");
            }
        }));

        new Thread("dividerZero"){
            @Override
            public void run() {
                super.run();
                System.out.println("dividerZeroThread:BEGIN");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int x = 1/0;

                System.out.println("dividerZeroThread:END");
            }
        }.start();
    }

}
