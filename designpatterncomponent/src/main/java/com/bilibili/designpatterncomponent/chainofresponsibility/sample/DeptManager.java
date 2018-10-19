package com.bilibili.designpatterncomponent.chainofresponsibility.sample;

public class DeptManager extends Handler {
    @Override
    public void handRequest(double fee, String name) {

        if (fee < 1000) {
            System.out.println("DeptManager同意了" + name + "的" + fee + "的请求");
        } else {
            if (getNext() != null) {
                getNext().handRequest(fee, name);
            } else {
                System.out.println("下级不见了");
            }
        }
    }
}
