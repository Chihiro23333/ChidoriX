package com.bilibili.designpatterncomponent.decorate;

public class Huli extends Hero {

    public Huli() {
        description = "狐狸";
    }

    @Override
    public int ad() {
        return 0;
    }

    @Override
    public int ap() {
        return 30;
    }

    @Override
    public int cost() {
        return 4800;
    }
}
