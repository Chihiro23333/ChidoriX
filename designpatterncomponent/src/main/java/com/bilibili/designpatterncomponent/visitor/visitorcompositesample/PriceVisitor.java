package com.bilibili.designpatterncomponent.visitor.visitorcompositesample;

public class PriceVisitor implements Visitor {

    private int total = 0;

    @Override
    public void visit(MainBoard mainBoard) {
        total += mainBoard.price();
    }

    @Override
    public void visit(HardDisk hardDisk) {
        total += hardDisk.price();
    }

    @Override
    public void visit(CPU cpu) {
        total += cpu.price();
    }

    @Override
    public void visit(Case ca) {
        total += ca.price();
    }

    @Override
    public void visit(IntergrateBoard intergrateBoard) {
        total += intergrateBoard.price();
    }

    @Override
    public void visit(PC pc) {
        total += pc.price();
    }

    public int price() {
        return total;
    }
}
