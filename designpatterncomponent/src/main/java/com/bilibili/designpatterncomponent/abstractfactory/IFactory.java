package com.bilibili.designpatterncomponent.abstractfactory;

public interface IFactory {
    IButton createButton();
    IText createText();
}
