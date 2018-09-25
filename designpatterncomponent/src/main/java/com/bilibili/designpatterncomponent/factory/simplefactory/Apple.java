package com.bilibili.designpatterncomponent.factory.simplefactory;

public class Apple implements IFruit {
    @Override
    public void grow() {
        System.out.println("苹果正在成长");
    }

    @Override
    public void harvest() {
        System.out.println("苹果收获了");
    }
}
