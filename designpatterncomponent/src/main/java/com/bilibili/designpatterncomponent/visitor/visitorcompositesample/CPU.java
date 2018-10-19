package com.bilibili.designpatterncomponent.visitor.visitorcompositesample;

public class CPU implements Equipment {
    @Override
    public void accept(Visitor visitor) {
        System.out.println("CPU被访问");
        visitor.visit(this);
    }

    @Override
    public int price() {
        return 1200;
    }
}
