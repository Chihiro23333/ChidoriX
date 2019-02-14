package com.bilibili.threadcomponent.producerconsumer.exchanger;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ConsumerThread extends Thread {

    private char[] buffer;
    private Exchanger<char[]> exchanger;

    private Random random;

    public ConsumerThread(char[] buffer, Exchanger<char[]> exchanger) {
        super("Consumer");
        this.buffer = buffer;
        this.exchanger = exchanger;
        random = new Random();
    }

    @Override
    public void run() {
        super.run();
        while (true){
            try {
                System.out.println(Thread.currentThread().getName() + "--BEFORE EXCHANGE");
                buffer = exchanger.exchange(buffer);
                System.out.println(Thread.currentThread().getName() + "--AFTER EXCHANGE");

                for (int i = 0; i < buffer.length; i++) {
                    System.out.println(Thread.currentThread().getName() + "--" + buffer[i]);
                    Thread.sleep(random.nextInt(1000));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
