package com.bilibili.threadcomponent.threadspecificstorage;

public class Test {

    public static void main(String args[]){
        new ClientThread().start();
        new ClientThread().start();
        new ClientThread().start();
    }

}
