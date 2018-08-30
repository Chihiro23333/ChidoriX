package com.bilibili.designpatterncomponent.factorymethod;

public class Test {
    /**
     * Factory Method  工厂方法
     * @param args
     */
    public static void main(String[] args) {
        IFruitFactory appleFactory = new AppleFactory();
        IFruit fruit = appleFactory.createFruit();
        fruit.grow();
        fruit.harvest();

        IFruitFactory grapeFactory = new GrapeFactory();
        IFruit fruit1 = grapeFactory.createFruit();
        fruit1.grow();
        fruit1.harvest();
    }
}
