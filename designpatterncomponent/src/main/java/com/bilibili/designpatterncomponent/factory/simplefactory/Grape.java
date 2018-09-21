package com.bilibili.designpatterncomponent.factory.simplefactory;

public class Grape implements IFruit {
    @Override
    public void grow() {
        System.out.println("葡萄正在成长");
    }

    @Override
    public void harvest() {
        System.out.println("葡萄收获了");
    }
}
