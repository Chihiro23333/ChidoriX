package com.bilibili.designpatterncomponent.visitor.visitorcompositesample;

import java.util.ArrayList;
import java.util.List;

public abstract class Composite implements Equipment {
    protected List<Equipment> list;

    public Composite() {
        this.list = new ArrayList<>();
    }

    public void add(Equipment equipment) {
        list.add(equipment);
    }

    @Override
    public int price() {

        int total = 0;

        for (int i = 0; i < list.size(); i++) {
            total += list.get(i).price();
        }

        return total;
    }

    @Override
    public void accept(Visitor visitor) {

        System.out.println(this.getClass().getSimpleName() + "被访问");

        for (int i = 0; i < list.size(); i++) {
            list.get(i).accept(visitor);
        }

    }
}
