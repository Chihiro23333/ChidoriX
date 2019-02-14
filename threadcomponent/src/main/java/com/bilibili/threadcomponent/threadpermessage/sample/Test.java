package com.bilibili.threadcomponent.threadpermessage.sample;

public class Test {

    public static void main(String args[]){
        System.out.println("MAIN BEGIN");
        Host host = new Host();
        host.request(10,'A');
        host.request(20,'B');
        host.request(30,'C');
        System.out.println("MAIN END");
    }

}
