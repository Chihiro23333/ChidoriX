package com.bilibili.threadcomponent.worker.sample;

public class Channel {

    private static final int MAX_REQUEST = 10;
    private Request[] requestQueue;
    private Thread[] workerThreads;

    private int head = 0;
    private int tail = 0;
    private int count = 0;

    public Channel(int threads){
        requestQueue = new Request[MAX_REQUEST];
        workerThreads = new Thread[threads];
        for (int i = 0; i < threads; i++) {
            workerThreads[i] = new WorkerThread("Worker-"+i, this);
        }
    }

    public void startWork(){
        for (int i = 0; i < workerThreads.length; i++) {
            workerThreads[i].start();
        }
    }

    public synchronized void putRequest(Request request){
        while (count >= MAX_REQUEST){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName()+":putRequest");
        requestQueue[tail] = request;
        tail = (tail + 1) % MAX_REQUEST;
        count++;
        notifyAll();
    }

    public synchronized Request takeRequest(){
        while (count <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName()+":takeRequest");
        Request request = requestQueue[head];
        head = (head + 1) % MAX_REQUEST;
        count--;
        notifyAll();
        return request;
    }

}
