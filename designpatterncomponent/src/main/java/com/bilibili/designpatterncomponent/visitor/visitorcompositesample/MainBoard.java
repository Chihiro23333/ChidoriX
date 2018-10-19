package com.bilibili.designpatterncomponent.visitor.visitorcompositesample;

public class MainBoard implements Equipment {
    @Override
    public void accept(Visitor visitor) {
        System.out.println("MainBoard被访问");
        visitor.visit(this);
    }

    @Override
    public int price() {
        return 2000;
    }
}
