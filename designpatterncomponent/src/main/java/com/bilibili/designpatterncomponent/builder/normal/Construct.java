package com.bilibili.designpatterncomponent.builder.normal;

public class Construct {

    private Builder builder;

    public Construct(Builder builder) {
        this.builder = builder;
    }

    public Message construct(String from ,String to){
        builder.buildFrom(from);
        builder.buildTo(to);
        builder.buildTitle();
        builder.buildContent();
        builder.buildTime();
        return builder.getMessage();
    }

}
