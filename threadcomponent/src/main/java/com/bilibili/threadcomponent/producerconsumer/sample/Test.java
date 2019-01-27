package com.bilibili.threadcomponent.producerconsumer.sample;

public class Test {

    public static void main(String args[]){
        Table table = new Table(3);

        new MakerThread("makerThread1",table).start();
        new MakerThread("makerThread2",table).start();
        new MakerThread("makerThread3",table).start();

        new EaterThread("eaterThread1",table).start();
        new EaterThread("eaterThread2",table).start();
        new EaterThread("eaterThread3",table).start();
    }

}
