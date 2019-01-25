package com.bilibili.threadcomponent.singlethreadexecution.deadlock;

public class Tool {
    private String name;

    public Tool(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
