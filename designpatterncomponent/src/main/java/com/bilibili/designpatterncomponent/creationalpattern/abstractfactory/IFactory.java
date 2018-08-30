package com.bilibili.designpatterncomponent.creationalpattern.abstractfactory;

public interface IFactory {
    IButton createButton();
    IText createText();
}
