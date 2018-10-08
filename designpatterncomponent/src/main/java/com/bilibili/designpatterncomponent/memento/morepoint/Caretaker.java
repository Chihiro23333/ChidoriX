package com.bilibili.designpatterncomponent.memento.morepoint;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {

    private List<Memento> list = new ArrayList<>();

    public void createMemento(Memento memento) {
        list.add(memento);
    }

    public void removeMemento(int index) {
        list.remove(index);
    }

    public Memento getMemento(int index) {
        return list.get(index);
    }

}
