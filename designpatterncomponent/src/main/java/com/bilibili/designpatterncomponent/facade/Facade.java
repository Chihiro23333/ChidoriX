package com.bilibili.designpatterncomponent.facade;

public class Facade {

    private Light light;
    private Camera camera;
    private AirCondition airCondition;


    public Facade() {
        this.light = new Light();
        this.camera = new Camera();
        this.airCondition = new AirCondition();
    }

    public void turnAllOn() {
        light.turnOn();
        camera.turnOn();
        airCondition.turnOn();
    }

    public void turnAllOff() {
        light.turnOff();
        camera.turnOff();
        airCondition.turnOff();
    }

    public void other() {
        System.out.println("其他方法");
    }
}
