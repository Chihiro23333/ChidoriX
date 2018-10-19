package com.bilibili.designpatterncomponent.visitor.visitorcompositesample;

public interface Equipment {

    void accept(Visitor visitor);

    int price();

}
