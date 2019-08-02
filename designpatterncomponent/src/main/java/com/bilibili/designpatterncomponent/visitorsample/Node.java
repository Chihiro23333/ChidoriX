package com.bilibili.designpatterncomponent.visitorsample;

/**
 * @author 朱峰 2019/8/1
 */
public interface Node {
    void accept(Visitor visitor);
}
