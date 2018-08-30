package com.bilibili.designpatterncomponent.abstractfactory;

public class UnixText implements IText {
    @Override
    public void click() {
        System.out.println("点击了一个UnixText");
    }
}
