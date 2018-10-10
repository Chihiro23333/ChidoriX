package com.bilibili.designpatterncomponent.visitor.sample;

public class Woman implements Person {


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
