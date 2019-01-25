package com.bilibili.threadcomponent.singlethreadexecution.sample;

public class Gate {

    private int count = 0;
    private String name = "NoBody";
    private String address = "NoAddress";


    public synchronized void pass(String name, String address) {
        this.count++;
        this.name = name;
        this.address = address;
        check();
    }

    @Override
    public String toString() {
        return "No." + count + ",name=" + name + ",address=" + address;
    }

    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("------BROKEN---------"+toString());
        }else {
            System.out.println(toString());
        }
    }
}
