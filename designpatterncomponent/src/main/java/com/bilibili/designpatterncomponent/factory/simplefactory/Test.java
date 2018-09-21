package com.bilibili.designpatterncomponent.factory.simplefactory;

public class Test {
    /**
     * Simple Factory  简单工厂模式 类的创建模式
     * @param args
     */
    public static void main(String[] args){
        IFruit apple = FruitFactory.createFruit("apple");
        IFruit grape = FruitFactory.createFruit("grape");

        apple.grow();
        apple.harvest();

        grape.grow();
        grape.harvest();
    }
}
