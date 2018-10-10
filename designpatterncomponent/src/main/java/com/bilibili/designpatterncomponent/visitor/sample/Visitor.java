package com.bilibili.designpatterncomponent.visitor.sample;

public interface Visitor {
    void visit(Man man);
    void visit(Woman woman);
}
