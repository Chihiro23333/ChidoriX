package com.bilibili.designpatterncomponent.builder.normal;

public class WelcomeBuilder extends Builder {

    @Override
    public void buildTitle() {
        message.setTitle("Welcome to Builder");
    }

    @Override
    public void buildContent() {
        message.setContent("Builder is good!!!");
    }
}
