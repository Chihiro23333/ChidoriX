package com.bilibili.designpatterncomponent.creationalpattern.factorymethod;

public class AppleFactory implements IFruitFactory{
    @Override
    public IFruit createFruit() {
        return new Apple();
    }
}
