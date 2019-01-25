package com.bilibili.threadcomponent.guardedsuspension;

public class Request {

    private final String name;

    public Request(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
