package com.bilibili.designpatterncomponent.chainofresponsibility.sample;

public class GeneralManager extends Handler {
    @Override
    public void handRequest(double fee, String name) {
        System.out.println("GeneralManager同意了" + name + "的" + fee + "的请求");
    }
}
