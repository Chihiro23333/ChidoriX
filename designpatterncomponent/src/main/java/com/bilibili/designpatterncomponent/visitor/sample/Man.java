package com.bilibili.designpatterncomponent.visitor.sample;

public class Man implements Person {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
