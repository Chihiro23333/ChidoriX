package com.bilibili.designpatterncomponent.visitor.visitorcompositesample;

public interface Visitor {

    void visit(MainBoard mainBoard);

    void visit(HardDisk hardDisk);

    void visit(CPU cpu);

    void visit(Case ca);

    void visit(IntergrateBoard intergrateBoard);

    void visit(PC pc);

}
