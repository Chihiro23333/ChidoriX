package com.bilibili.threadcomponent.worker.sample;

public class Test {

    public static void main(String args[]){
        Channel channel = new Channel(5);
        channel.startWork();
        new ClientThread("NO.ONE",channel).start();
        new ClientThread("NO.TWO",channel).start();
        new ClientThread("NO.THREE",channel).start();
    }

}
