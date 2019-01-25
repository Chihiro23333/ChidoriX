package com.bilibili.threadcomponent.singlethreadexecution.semaphore;

public class Test {

    public static void main(String args[]) {
        BoundedResource boundedResource = new BoundedResource(3);
        for (int i = 0; i < 2; i++) {
            new UseThread(boundedResource).start();
        }
    }
}
