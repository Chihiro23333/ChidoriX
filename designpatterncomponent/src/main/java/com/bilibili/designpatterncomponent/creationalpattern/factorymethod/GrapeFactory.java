package com.bilibili.designpatterncomponent.creationalpattern.factorymethod;

public class GrapeFactory implements IFruitFactory {
    @Override
    public IFruit createFruit() {
        return new Grape();
    }
}
