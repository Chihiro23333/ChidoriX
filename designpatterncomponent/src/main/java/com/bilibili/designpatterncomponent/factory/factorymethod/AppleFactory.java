package com.bilibili.designpatterncomponent.factory.factorymethod;

public class AppleFactory implements IFruitFactory{
    @Override
    public IFruit createFruit() {
        return new Apple();
    }
}
