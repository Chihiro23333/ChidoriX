package com.bilibili.designpatterncomponent.facade;

public class Light {
    public void turnOn(){
        System.out.println("打开电灯");
    }

    public void turnOff(){
        System.out.println("关闭电灯");
    }

    public void changeBulb(){
        System.out.println("更换灯泡");
    }
}
