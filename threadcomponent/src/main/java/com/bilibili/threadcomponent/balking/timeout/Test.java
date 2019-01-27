package com.bilibili.threadcomponent.balking.timeout;

import java.util.concurrent.TimeoutException;

public class Test {

    public static void main(String args[]){
        Host host = new Host(5000);
        try {
            host.execute();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
