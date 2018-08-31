package com.bilibili.designpatterncomponent.bridge;

public class PassengerAirplane extends Airplane {

    public PassengerAirplane(AirplaneProducer airplaneProducer) {
        this.airplaneProducer = airplaneProducer;
    }

    @Override
    public void fly() {
        airplaneProducer.produce();
        System.out.println("客机起飞");
    }
}
