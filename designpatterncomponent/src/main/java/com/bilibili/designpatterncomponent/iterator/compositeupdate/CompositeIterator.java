package com.bilibili.designpatterncomponent.iterator.compositeupdate;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator {

    private Stack stack = new Stack();

    public CompositeIterator(Iterator iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        } else {
            Iterator iterator = (Iterator) stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }

    }

    @Override
    public Object next() {

        Iterator iterator = (Iterator) stack.peek();
        MenuComponent menuComponent = (MenuComponent) iterator.next();
        if(menuComponent instanceof Menu){
            stack.push(menuComponent.createIterator());
        }
        return menuComponent;
    }
}
