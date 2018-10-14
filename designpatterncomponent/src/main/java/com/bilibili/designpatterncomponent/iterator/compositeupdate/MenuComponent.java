package com.bilibili.designpatterncomponent.iterator.compositeupdate;

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

    public Iterator createIterator() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}
