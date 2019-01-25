package com.bilibili.threadcomponent.singlethreadexecution.deadlock;

public class Test {
    public static void main(String args[]) {
        Tool spoon = new Tool("spoon");
        Tool fork = new Tool("fork");

        new EatThread("alice", fork, spoon).start();
        new EatThread("bob", fork, spoon).start();
    }
}
