package com.bilibili.designpatterncomponent.facade;

public class AirCondition {
    public void turnOn() {
        System.out.println("打开空调");
    }

    public void turnOff() {
        System.out.println("关闭空调");
    }

    public void clean() {
        System.out.println("清洁空调");
    }
}
