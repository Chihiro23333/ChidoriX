package com.bilibili.designpatterncomponent.factory.abstractfactory;

public class UnixButton implements IButton {
    @Override
    public void click() {
        System.out.println("点击了一个UnixButton");
    }
}
