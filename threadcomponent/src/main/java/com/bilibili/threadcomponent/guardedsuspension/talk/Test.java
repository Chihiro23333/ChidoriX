package com.bilibili.threadcomponent.guardedsuspension.talk;

import com.bilibili.threadcomponent.guardedsuspension.sample.Request;
import com.bilibili.threadcomponent.guardedsuspension.sample.RequestQueue;

public class Test {

    public static void main(String args[]){
        RequestQueue requestQueue = new RequestQueue();
        RequestQueue requestQueue1 = new RequestQueue();

        requestQueue.putRequest(new Request("start"));

        new TalkThread(requestQueue ,requestQueue1 ,"one").start();
        new TalkThread(requestQueue1 ,requestQueue ,"two").start();
    }

}
