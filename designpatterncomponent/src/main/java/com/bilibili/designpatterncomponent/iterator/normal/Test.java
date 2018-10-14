package com.bilibili.designpatterncomponent.iterator.normal;

/**
 * 提供一个方法顺序访问一个聚合对象中的各个元素,而又不暴露其内部的表示
 *
 *
 */
public class Test {
    public static void main(String[] args) {
        KFC kfc = new KFC();
        Mcdonalds mcdonalds = new Mcdonalds();

        Waitress waitress = new Waitress(kfc, mcdonalds);
        waitress.printAllMenu();
    }
}
