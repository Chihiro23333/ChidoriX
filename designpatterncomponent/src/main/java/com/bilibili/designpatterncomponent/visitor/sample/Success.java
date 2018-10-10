package com.bilibili.designpatterncomponent.visitor.sample;

public class Success implements Visitor {
    @Override
    public void visit(Man man) {
        System.out.println("成功的男人背后一个号女人");
    }

    @Override
    public void visit(Woman woman) {
        System.out.println("成功的女人背后有个失败的男人");
    }

}
