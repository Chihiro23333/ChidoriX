package com.bilibili.designpatterncomponent.memento.blackbox;

public class Caretaker {
    private MementoIF mementoIF;

    public MementoIF getMementoIF() {
        return mementoIF;
    }

    public void setMementoIF(MementoIF mementoIF) {
        this.mementoIF = mementoIF;
    }
}
