package com.bilibili.threadcomponent.guardedsuspension.sample;

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
