package com.bilibili.designpatterncomponent.visitor.normal;

public class NodeB implements Node {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationB() {
        System.out.println("NodeB operationB");
    }
}
