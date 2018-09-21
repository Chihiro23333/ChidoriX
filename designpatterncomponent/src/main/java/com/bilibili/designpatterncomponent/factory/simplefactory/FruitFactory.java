package com.bilibili.designpatterncomponent.factory.simplefactory;

public class FruitFactory {
    public static IFruit createFruit(String type) {
        switch (type) {
            case "apple":
                return new Apple();
            case "grape":
                return new Grape();
            default:
                throw new RuntimeException("不存在这种水果类型");
        }
    }
}
