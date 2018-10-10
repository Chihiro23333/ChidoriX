package com.bilibili.designpatterncomponent.visitor.sample;

public class Test {
    public static void main(String[] args){
        ObjectStructure objectStructure = new ObjectStructure();

        Person man = new Man();
        Person woman = new Woman();

        objectStructure.add(man);
        objectStructure.add(woman);

        Visitor love = new Love();
        objectStructure.visitAll(love);

        Visitor success = new Success();
        objectStructure.visitAll(success);

        Visitor fail = new Fail();
        objectStructure.visitAll(fail);
    }
}
