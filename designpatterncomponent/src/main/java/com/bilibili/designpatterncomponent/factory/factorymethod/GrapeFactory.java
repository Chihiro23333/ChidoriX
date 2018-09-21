package com.bilibili.designpatterncomponent.factory.factorymethod;

public class GrapeFactory implements IFruitFactory {
    @Override
    public IFruit createFruit() {
        return new Grape();
    }
}
