package com.bilibili.threadcomponent.balking.sample;

public class Test {

    public static void main(String args[]){
        Data data = new Data("data","NONE");

        new ChangerThread("changer",data).start();
        new SaverThread("saver",data).start();
    }

}
