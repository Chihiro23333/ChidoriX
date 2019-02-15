package com.bilibili.threadcomponent.worker.threadpoolexecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String args[]) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        new ClientThread("NO.ONE", executorService).start();
        new ClientThread("NO.TWO", executorService).start();
        new ClientThread("NO.THREE", executorService).start();
    }

}
