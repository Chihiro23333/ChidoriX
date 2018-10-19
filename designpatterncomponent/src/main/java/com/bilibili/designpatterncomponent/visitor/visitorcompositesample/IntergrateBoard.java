package com.bilibili.designpatterncomponent.visitor.visitorcompositesample;

public class IntergrateBoard extends Composite {
    public IntergrateBoard() {
        add(new MainBoard());
        add(new HardDisk());
    }
}
