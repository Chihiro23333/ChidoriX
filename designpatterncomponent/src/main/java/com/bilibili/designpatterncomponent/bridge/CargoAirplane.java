package com.bilibili.designpatterncomponent.bridge;

public class CargoAirplane extends Airplane {

    public CargoAirplane(AirplaneProducer airplaneProducer) {
        this.airplaneProducer = airplaneProducer;
    }

    @Override
    public void fly() {
        airplaneProducer.produce();
        System.out.println("货机起飞");
    }
}
