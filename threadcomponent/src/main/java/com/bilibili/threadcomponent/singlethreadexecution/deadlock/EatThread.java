package com.bilibili.threadcomponent.singlethreadexecution.deadlock;

public class EatThread extends Thread {

    private String name;
    private Tool leftHand;
    private Tool rightHand;

    public EatThread(String name, Tool leftHand, Tool rightHand) {
        this.name = name;
        this.leftHand = leftHand;
        this.rightHand = rightHand;
    }

    @Override
    public void run() {
        while (true) {
            eat();
        }
    }

    private void eat() {
        synchronized (leftHand) {
            System.out.println(name + "take up" + leftHand + "left");
            synchronized (rightHand) {
                System.out.println(name + "take up" + rightHand + "right.");
                System.out.println(name + "put down" + rightHand + "right");
            }
            System.out.println(name + "put down" + leftHand + "left");
        }
    }
}
