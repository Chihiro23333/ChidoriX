package com.bilibili.designpatterncomponent.memento.blackbox;

public class Test {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("001");
        System.out.println(originator.getState());

        originator.setState("002");
        System.out.println(originator.getState());
        caretaker.setMementoIF(originator.createMemento());

        originator.setState("003");
        System.out.println(originator.getState());

        originator.restoreTo(caretaker.getMementoIF());
        System.out.println(originator.getState());
    }
}
