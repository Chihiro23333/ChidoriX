package com.bilibili.designpatterncomponent.chainofresponsibility.sample;

public class ProjectManager extends Handler {
    @Override
    public void handRequest(double fee, String name) {
        if (fee < 500) {
            System.out.println("ProjectManager同意" + name + "的" + fee + "的请求");
        } else {
            if (getNext() != null) {
                getNext().handRequest(fee, name);
            } else {
                System.out.println("下级不见了");
            }
        }
    }
}
