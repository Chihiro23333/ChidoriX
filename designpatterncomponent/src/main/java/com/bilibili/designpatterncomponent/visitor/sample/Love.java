package com.bilibili.designpatterncomponent.visitor.sample;

public class Love implements Visitor {
    @Override
    public void visit(Man man) {
        System.out.println("恋爱的男人什么不会也得会");
    }

    @Override
    public void visit(Woman woman) {
        System.out.println("恋爱的女人什么会也装作不会");
    }
}
