package com.bilibili.threadcomponent.producerconsumer.exchanger;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ProducerThread extends Thread {

    private char[] buffer;
    private Exchanger<char[]> exchanger;

    private int index = 0;
    private Random random;

    public ProducerThread(char[] buffer, Exchanger<char[]> exchanger) {
        super("Producer");
        this.buffer = buffer;
        this.exchanger = exchanger;
        random = new Random();
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            try {
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] = nextChar();
                    System.out.println(Thread.currentThread().getName() + "--" + buffer[i]);
                }

                System.out.println(Thread.currentThread().getName() + "--BEFORE EXCHANGE");
                buffer = exchanger.exchange(buffer);
                System.out.println(Thread.currentThread().getName() + "--AFTER EXCHANGE");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private char nextChar() throws InterruptedException {
        char c = (char) ('A' + index % 26);
        index++;
        Thread.sleep(random.nextInt(1000));
        return c;
    }

}
