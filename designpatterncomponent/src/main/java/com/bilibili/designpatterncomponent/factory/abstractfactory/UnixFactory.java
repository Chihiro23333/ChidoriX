package com.bilibili.designpatterncomponent.factory.abstractfactory;

public class UnixFactory implements IFactory {
    @Override
    public IButton createButton() {
        return new UnixButton();
    }

    @Override
    public IText createText() {
        return new UnixText();
    }
}
