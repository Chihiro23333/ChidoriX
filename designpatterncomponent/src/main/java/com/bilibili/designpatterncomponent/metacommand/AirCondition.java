package com.bilibili.designpatterncomponent.metacommand;

public class AirCondition {

    public void on(){
        System.out.println("开空调");
    }

    public void off(){
        System.out.println("关空调");
    }

    public void up(){
        System.out.println("调高温度");
    }

    public void down(){
        System.out.println("调低温度");
    }
}
