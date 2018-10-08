package com.bilibili.designpatterncomponent.decorate;

public class MangWan extends Hero {

    public MangWan() {
        description = "蛮王";
    }

    @Override
    public int ad() {
        return 23;
    }

    @Override
    public int ap() {
        return 0;
    }

    @Override
    public int cost() {
        return 6800;
    }
}
