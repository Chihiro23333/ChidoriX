package com.bilibili.designpatterncomponent.visitor.normal;

public class Test {

    public static void main(String[] args){
        Visitor visitorA = new VisitA();
        Visitor visitorB = new VisitB();

        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.add(new NodeA());
        objectStructure.add(new NodeB());

        objectStructure.action(visitorA);
        objectStructure.action(visitorB);
    }

}
