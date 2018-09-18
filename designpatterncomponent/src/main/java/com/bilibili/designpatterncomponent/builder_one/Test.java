package com.bilibili.designpatterncomponent.builder_one;

public class Test {
    public static void main(String[] args){
        Message message = new Builder()
                .setFrom("Chidori")
                .setTo("Kana")
                .setContent("i miss you")
                .setTime("today")
                .setTitle("is here")
                .build();
        message.send();
    }
}
