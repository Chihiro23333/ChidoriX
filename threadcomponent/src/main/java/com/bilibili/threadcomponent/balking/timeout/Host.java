package com.bilibili.threadcomponent.balking.timeout;

import java.util.concurrent.TimeoutException;

public class Host {

    private long timeout;
    private boolean ready = false;

    public Host(long timeout) {
        this.timeout = timeout;
    }

    public synchronized void setExecutable(boolean on){
        this.ready = on;
        notifyAll();
    }

    public synchronized void execute() throws TimeoutException, InterruptedException {
        long start = System.currentTimeMillis();
        while (!ready){
            long end = System.currentTimeMillis();
            long rest = timeout - (end - start);
            if(rest <= 0){
                throw new TimeoutException("timeout="+timeout+"gap="+(end-start));
            }
            wait(rest);
        }
        doExecute();
    }

    private void doExecute() {
        System.out.println(Thread.currentThread().getName()+"doExecute");
    }

}
