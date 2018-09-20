package com.bilibili.designpatterncomponent.facade;

public class Camera {

    public void turnOn() {
        System.out.println("打开摄像头");
    }

    public void turnOff() {
        System.out.println("关闭摄像头");
    }

    public void repair() {
        System.out.println("维修摄像头");
    }
}
