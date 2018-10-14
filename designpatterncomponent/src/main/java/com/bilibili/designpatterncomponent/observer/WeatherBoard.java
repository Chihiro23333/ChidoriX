package com.bilibili.designpatterncomponent.observer;

public class WeatherBoard implements Observer {
    @Override
    public void update(Subject subject ,String temperature) {
        System.out.println("当前温度是:" + temperature);
    }
}
