package com.bilibili.designpatterncomponent.abstractfactory;

public class Test {
    /**
     * Abstract Factory  抽象工厂
     * @param args
     */
    public static void main(String[] args) {
        IFactory unixFactory = new UnixFactory();
        IButton unixButton = unixFactory.createButton();
        IText unixText = unixFactory.createText();
        unixButton.click();
        unixText.click();

        IFactory windowsFactory = new WindowsFactory();
        IButton windowsButton = windowsFactory.createButton();
        IText windowsText = windowsFactory.createText();
        windowsButton.click();
        windowsText.click();
    }
}
