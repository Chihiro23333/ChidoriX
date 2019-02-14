package com.bilibili.threadcomponent.producerconsumer.exchanger;

import java.util.concurrent.Exchanger;

public class Test {

    public static void main(String args[]){
        Exchanger<char[]> exchanger = new Exchanger<>();
        char[] buffer1 = new char[10];
        char[] buffer2 = new char[10];
        new ProducerThread(buffer1 ,exchanger).start();
        new ConsumerThread(buffer2 ,exchanger).start();
    }
}
