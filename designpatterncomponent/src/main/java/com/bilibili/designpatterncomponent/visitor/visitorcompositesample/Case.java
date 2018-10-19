package com.bilibili.designpatterncomponent.visitor.visitorcompositesample;

public class Case implements Equipment {
    @Override
    public void accept(Visitor visitor) {
        System.out.println("Case被访问");
        visitor.visit(this);
    }

    @Override
    public int price() {
        return 200;
    }
}
