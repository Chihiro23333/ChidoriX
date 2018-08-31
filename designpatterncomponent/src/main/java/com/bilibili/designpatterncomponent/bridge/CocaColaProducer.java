package com.bilibili.designpatterncomponent.bridge;

public class CocaColaProducer implements AirplaneProducer {
    @Override
    public void produce() {
        System.out.println("可口可乐制造");
    }
}
