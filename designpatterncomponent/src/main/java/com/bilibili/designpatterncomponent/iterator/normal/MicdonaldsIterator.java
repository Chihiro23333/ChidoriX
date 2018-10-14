package com.bilibili.designpatterncomponent.iterator.normal;

import java.util.List;

public class MicdonaldsIterator implements Iterator {

    private List<MenuItem> list;

    private int curPosition = 0;

    public MicdonaldsIterator(List<MenuItem> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (curPosition < list.size()) {
            return true;
        }
        return false;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = list.get(curPosition);
        curPosition++;
        return menuItem;
    }
}
