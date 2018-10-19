package com.bilibili.designpatterncomponent.visitor.visitorcompositesample;

public class PC extends Composite {
    public PC() {
        add(new MainBoard());
        add(new CPU());
        add(new Case());
        add(new HardDisk());
    }
}
