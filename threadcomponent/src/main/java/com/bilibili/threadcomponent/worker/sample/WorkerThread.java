package com.bilibili.threadcomponent.worker.sample;

public class WorkerThread extends Thread{

    private Channel channel;

    public WorkerThread(String name, Channel channel){
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        super.run();
        while (true){
            Request request = channel.takeRequest();
            request.execute();
        }
    }
}
