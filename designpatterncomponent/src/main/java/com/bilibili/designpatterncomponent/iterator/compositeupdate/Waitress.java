package com.bilibili.designpatterncomponent.iterator.compositeupdate;

import java.util.Iterator;

public class Waitress {
    private MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void print() {
        Iterator iterator = allMenus.createIterator();
        while (iterator.hasNext()){
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            menuComponent.print();
        }
    }
}
