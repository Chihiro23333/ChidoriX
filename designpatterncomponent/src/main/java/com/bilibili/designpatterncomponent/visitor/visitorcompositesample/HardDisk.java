package com.bilibili.designpatterncomponent.visitor.visitorcompositesample;

public class HardDisk implements Equipment {
    @Override
    public void accept(Visitor visitor) {
        System.out.println("HardDisk被访问");
        visitor.visit(this);
    }

    @Override
    public int price() {
        return 300;
    }
}
