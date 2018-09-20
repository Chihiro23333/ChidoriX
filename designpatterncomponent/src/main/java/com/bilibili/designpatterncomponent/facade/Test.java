package com.bilibili.designpatterncomponent.facade;

public class Test {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.turnAllOn();
        facade.turnAllOff();
        facade.other();
    }
}

