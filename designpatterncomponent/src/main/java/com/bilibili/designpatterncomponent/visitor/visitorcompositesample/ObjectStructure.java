package com.bilibili.designpatterncomponent.visitor.visitorcompositesample;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {

    private List<Equipment> list;

    public ObjectStructure() {
        this.list = new ArrayList<>();
    }

    public void add(Equipment equipment) {
        list.add(equipment);
    }

    public void visit(Visitor visitor) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).accept(visitor);
        }
    }

}
