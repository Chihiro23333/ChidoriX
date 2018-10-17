package com.bilibili.designpatterncomponent.observer;

public class Test {
    public static void main(String args[]) {
        Weather weather = new Weather();
        Observer observer = new WeatherBoard();

        weather.registerObserver(observer);

        weather.setTemperature("30度");
        weather.setTemperature("40度");
        weather.setTemperature("42度");

        weather.removeObserver(observer);
        weather.setTemperature("20度");
    }
}
