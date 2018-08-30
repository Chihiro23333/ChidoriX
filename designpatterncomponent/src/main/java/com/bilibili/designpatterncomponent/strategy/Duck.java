package com.bilibili.designpatterncomponent.strategy;

public abstract class Duck {

    protected IFlyBehavior flyBehavior;

    protected IQuackBehavior quackBehavior;

    public void setFlyBehavior(IFlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(IQuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public  void swim(){
        System.out.println("全部鸭子都会游泳");
    };

    public  void fly(){
        flyBehavior.fly();
    };

    public void quack(){
        quackBehavior.quack();
    }

    public abstract void display();
}
