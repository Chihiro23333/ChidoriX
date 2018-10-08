package com.bilibili.designpatterncomponent.memento.morepoint;

public class Test {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("001");
        caretaker.createMemento(originator.createMemento());
        System.out.println(originator.getState());
        originator.setState("002");
        caretaker.createMemento(originator.createMemento());
        System.out.println(originator.getState());
        originator.setState("003");
        caretaker.createMemento(originator.createMemento());
        System.out.println(originator.getState());

        originator.restoreMemento(caretaker.getMemento(1));
        System.out.println(originator.getState());
        originator.restoreMemento(caretaker.getMemento(0));
        System.out.println(originator.getState());
    }
}
