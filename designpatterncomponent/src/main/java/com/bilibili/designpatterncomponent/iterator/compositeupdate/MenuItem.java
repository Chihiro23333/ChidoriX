package com.bilibili.designpatterncomponent.iterator.compositeupdate;

import java.util.Iterator;

public class MenuItem extends MenuComponent {
    private String name;
    private String description;

    public MenuItem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Iterator createIterator() {
        return new NullIterator();
    }

    @Override
    public void print() {
        System.out.println("MenuItem" + name + "=" + description);
    }
}
