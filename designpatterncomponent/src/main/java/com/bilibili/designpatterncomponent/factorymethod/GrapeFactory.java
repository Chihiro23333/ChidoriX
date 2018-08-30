package com.bilibili.designpatterncomponent.factorymethod;

public class GrapeFactory implements IFruitFactory {
    @Override
    public IFruit createFruit() {
        return new Grape();
    }
}
