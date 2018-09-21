package com.bilibili.designpatterncomponent.visitor.normal;

public class VisitA implements Visitor {
    @Override
    public void visit(NodeA nodeA) {
        System.out.println("VisitA");
        nodeA.operationA();
    }

    @Override
    public void visit(NodeB nodeB) {
        System.out.println("VisitA");
        nodeB.operationB();
    }
}
