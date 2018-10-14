package com.bilibili.designpatterncomponent.iterator.composite;

import java.util.Iterator;

public abstract class MenuComponent {

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public void addChild(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void removeChild(int index) {
        throw new UnsupportedOperationException();
    }


    public void print() {
        throw new UnsupportedOperationException();
    }
}
