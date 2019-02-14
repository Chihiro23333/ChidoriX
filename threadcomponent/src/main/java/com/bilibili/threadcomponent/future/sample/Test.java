package com.bilibili.threadcomponent.future.sample;

public class Test {

    public static void main(String args[]) {

        Host host = new Host();
        Data data1 = host.request(10, 'A');
        Data data2 = host.request(20, 'B');
        Data data3 = host.request(30, 'C');

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(data1.getContent());
        System.out.println(data2.getContent());
        System.out.println(data3.getContent());
    }

}
