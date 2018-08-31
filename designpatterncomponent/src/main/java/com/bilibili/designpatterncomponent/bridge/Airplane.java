package com.bilibili.designpatterncomponent.bridge;

public abstract class Airplane {

    protected AirplaneProducer airplaneProducer;

    abstract void fly();
}
