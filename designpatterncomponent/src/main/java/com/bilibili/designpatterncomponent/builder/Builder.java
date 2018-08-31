package com.bilibili.designpatterncomponent.builder;

public abstract class Builder {

    protected Message message;

    public Builder() {
        message = new Message();
    }

    void buildFrom(String from) {
        message.setFrom(from);
    }

    void buildTo(String to) {
        message.setTo(to);
    }


    void buildTime() {
        message.setTime(System.currentTimeMillis() + "");
    }

    abstract void buildTitle();

    abstract void buildContent();

    public Message getMessage() {
        return message;
    }
}
