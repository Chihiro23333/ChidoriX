package com.bilibili.designpatterncomponent.visitor.normal;

public class NodeA implements Node {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationA(){
        System.out.println("NodeA operationA");
    }
}
