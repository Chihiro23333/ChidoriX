package com.bilibili.designpatterncomponent.visitor.sample;

public class Fail implements Visitor {
    @Override
    public void visit(Man man) {
        System.out.println("失败的男人");
    }

    @Override
    public void visit(Woman woman) {
        System.out.println("失败的女人");
    }
}
