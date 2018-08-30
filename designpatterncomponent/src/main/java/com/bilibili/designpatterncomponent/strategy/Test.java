package com.bilibili.designpatterncomponent.strategy;

public class Test {
    /**
     * Strategy Pattern
     * 策略模式
     *
     * 定义了算法族,分别封装起来,让他们之间ke可以相互替换,
     * 此模式让算法独立于算法的客户
     * * @param args
     */
    public static void main(String[] args){
        Duck redHeadDuck = new RedHeadDuck();
        Duck noLifeDuck = new NoLifeDuck();

        redHeadDuck.display();
        redHeadDuck.swim();
        redHeadDuck.fly();
        redHeadDuck.quack();

        noLifeDuck.display();
        noLifeDuck.swim();
        noLifeDuck.fly();
        noLifeDuck.quack();

        //用set方法可以改变不同鸭子的行为，不能飞的木鸭子在替换行为之后能叫和飞行
        noLifeDuck.setQuackBehavior(new GuaGuaQuack());
        noLifeDuck.setFlyBehavior(new FlyWithWings());

        noLifeDuck.quack();
        noLifeDuck.fly();
    }
}
