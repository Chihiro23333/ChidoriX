package com.bilibili.designpatterncomponent.builder.normal;

public class ByeBuilder extends Builder {
    @Override
    public void buildTitle() {
        message.setTitle("Bye to Builder");
    }

    @Override
    public void buildContent() {
        message.setContent("Builder is bad byebye!!!");
    }
}
