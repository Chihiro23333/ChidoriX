package com.bilibili.designpatterncomponent.iterator.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponent {

    private String name;

    private String description;

    private List<MenuComponent> list = new ArrayList<>();

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void addChild(MenuComponent menuComponent) {
        list.add(menuComponent);
    }

    @Override
    public void removeChild(int index) {
        list.remove(index);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void print() {

        System.out.println("Menu" + name + "=" + description);

        Iterator<MenuComponent> iterator = list.iterator();
        while (iterator.hasNext()) {
            MenuComponent next = iterator.next();
            next.print();
        }

    }
}
