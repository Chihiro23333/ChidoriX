package com.bilibili.designpatterncomponent.factory.abstractfactory;

public interface IFactory {
    IButton createButton();
    IText createText();
}
