package com.bilibili.threadcomponent.guardedsuspension;

public class Test {
    public static void main(String args[]) {
        RequestQueue requestQueue = new RequestQueue();
        new ServerThread(requestQueue, 1000).start();
        new ClientThread(requestQueue, 1000).start();
    }
}
