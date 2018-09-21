package com.bilibili.designpatterncomponent.visitor.normal;

public class VisitB implements Visitor {
    @Override
    public void visit(NodeA nodeA) {
        System.out.println("VisitB");
        nodeA.operationA();
    }

    @Override
    public void visit(NodeB nodeB) {
        System.out.println("VisitB");
        nodeB.operationB();
    }
}
