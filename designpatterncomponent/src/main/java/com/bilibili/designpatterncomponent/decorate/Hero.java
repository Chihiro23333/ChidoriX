package com.bilibili.designpatterncomponent.decorate;

public abstract class Hero {

    protected String description = "no description";

    public String getDescription() {
        return description;
    }

    public abstract int ad();

    public abstract int ap();

    public abstract int cost();
}
