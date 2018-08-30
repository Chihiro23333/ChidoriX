package com.bilibili.designpatterncomponent.strategy;

public class NoLifeDuck extends Duck {

    public NoLifeDuck() {
        flyBehavior  = new FlyNo();
        quackBehavior =  new NoQuack();
    }

    @Override
    public void display() {
        System.out.println("没有生命的木头鸭子");
    }
}
