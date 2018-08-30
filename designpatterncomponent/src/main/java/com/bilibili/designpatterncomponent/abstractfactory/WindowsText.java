package com.bilibili.designpatterncomponent.abstractfactory;

public class WindowsText implements IText {
    @Override
    public void click() {
        System.out.println("点击了一个WindowsText");
    }
}
