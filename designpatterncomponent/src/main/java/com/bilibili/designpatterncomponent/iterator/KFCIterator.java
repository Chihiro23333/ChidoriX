package com.bilibili.designpatterncomponent.iterator;

public class KFCIterator implements Iterator {

    private MenuItem[] menuItems;

    private int curPosition = 0;

    public KFCIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if (curPosition < menuItems.length && menuItems[curPosition] != null) {
            return true;
        }
        return false;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = menuItems[curPosition];
        curPosition++;
        return menuItem;
    }
}
