package com.bilibili.designpatterncomponent.abstractfactory;

public class WindowsFactory implements IFactory {
    @Override
    public IButton createButton() {
        return new WindowsButton();
    }

    @Override
    public IText createText() {
        return new WindowsText();
    }
}
