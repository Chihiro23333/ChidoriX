package com.bilibili.designpatterncomponent.creationalpattern.abstractfactory;

public class WindowsButton implements IButton{
    @Override
    public void click() {
        System.out.println("点击了一个WindowsButton");
    }
}
