package com.bilibili.designpatterncomponent.adapter;

import java.util.Enumeration;
import java.util.Iterator;


/**
 * 实现Target接口并持有Adaptee接口
 */

public class EnumerationIterator implements Iterator {

    private Enumeration enumeration;

    public EnumerationIterator(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }


    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
