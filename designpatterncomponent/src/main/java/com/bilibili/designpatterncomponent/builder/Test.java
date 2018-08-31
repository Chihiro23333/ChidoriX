package com.bilibili.designpatterncomponent.builder;

public class Test {
    public static void main(String[] args) {
        Builder welcomeBuilder = new WelcomeBuilder();
        Builder byeBuilder = new ByeBuilder();

        Construct construct = new Construct(welcomeBuilder);
        Message message = construct.construct("163.com", "qq.com");
        message.send();

        Construct construct1 = new Construct(byeBuilder);
        Message message1 = construct1.construct("gmail.com", "pp.com");
        message1.send();
    }
}
