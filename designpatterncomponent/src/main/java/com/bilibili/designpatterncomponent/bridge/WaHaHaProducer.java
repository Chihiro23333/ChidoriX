package com.bilibili.designpatterncomponent.bridge;

public class WaHaHaProducer implements AirplaneProducer {
    @Override
    public void produce() {
        System.out.println("娃哈哈制造");
    }
}
