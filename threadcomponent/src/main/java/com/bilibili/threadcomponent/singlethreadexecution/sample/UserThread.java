package com.bilibili.threadcomponent.singlethreadexecution.sample;

public class UserThread extends Thread {

    private final Gate gate;
    private final String name;
    private final String address;

    public UserThread(Gate gate, String name, String address) {
        this.gate = gate;
        this.name = name;
        this.address = address;
    }

    @Override
    public void run() {
        while (true) {
            gate.pass(name, address);
        }
    }
}
