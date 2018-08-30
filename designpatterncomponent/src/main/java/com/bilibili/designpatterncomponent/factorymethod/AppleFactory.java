package com.bilibili.designpatterncomponent.factorymethod;

public class AppleFactory implements IFruitFactory{
    @Override
    public IFruit createFruit() {
        return new Apple();
    }
}
