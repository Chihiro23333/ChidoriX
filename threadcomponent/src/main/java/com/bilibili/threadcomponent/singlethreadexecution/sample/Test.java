package com.bilibili.threadcomponent.singlethreadexecution.sample;

public class Test {
    public static void main(String args[]) {
        Gate gate = new Gate();
        new UserThread(gate, "Alice", "Addddas").start();
        new UserThread(gate, "Blice", "Bddddas").start();
        new UserThread(gate, "Clice", "Cddddas").start();
        new UserThread(gate, "Dlice", "Dddddas").start();
        new UserThread(gate, "Elice", "Eddddas").start();
        new UserThread(gate, "Flice", "Fddddas").start();
        new UserThread(gate, "Glice", "Gddddas").start();
    }
}
