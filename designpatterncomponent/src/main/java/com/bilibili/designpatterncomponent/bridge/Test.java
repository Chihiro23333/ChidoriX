package com.bilibili.designpatterncomponent.bridge;

public class Test {
    public static void main(String[] args){
        WaHaHaProducer waHaHaProducer = new WaHaHaProducer();
        CocaColaProducer cocaColaProducer = new CocaColaProducer();

        Airplane cargoAirplane = new CargoAirplane(waHaHaProducer);
        Airplane cargoAirplane1 = new CargoAirplane(cocaColaProducer);

        Airplane airplane = new PassengerAirplane(waHaHaProducer);

        cargoAirplane.fly();
        cargoAirplane1.fly();

        airplane.fly();
    }
}
