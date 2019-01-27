package com.bilibili.threadcomponent.producerconsumer.sample;

public class Table {

    private String[] buffer;
    private int tail;
    private int head;
    private int count;

    public Table(int count) {
        buffer = new String[count];
        tail = 0;
        head = 0;
        this.count = 0;
    }

    public synchronized void put(String cake){
        while (count >= buffer.length){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " put cake= "+cake);
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        notifyAll();
    }

    public synchronized String get(){
        while (count <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String cake = buffer[head];
        head++;
        head = (head + 1) % buffer.length;
        count--;
        System.out.println(Thread.currentThread().getName() + " get cake= "+ cake);
        notifyAll();
        return cake;
    }
}
