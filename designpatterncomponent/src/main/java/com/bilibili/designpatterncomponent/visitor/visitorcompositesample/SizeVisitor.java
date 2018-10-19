package com.bilibili.designpatterncomponent.visitor.visitorcompositesample;

import java.util.ArrayList;
import java.util.List;

public class SizeVisitor implements Visitor {
    private List<Equipment> list;

    public SizeVisitor() {
        list = new ArrayList<>();
    }

    @Override
    public void visit(MainBoard mainBoard) {
        list.add(mainBoard);
    }

    @Override
    public void visit(HardDisk hardDisk) {
        list.add(hardDisk);
    }

    @Override
    public void visit(CPU cpu) {
        list.add(cpu);
    }

    @Override
    public void visit(Case ca) {
        list.add(ca);
    }

    @Override
    public void visit(IntergrateBoard intergrateBoard) {
        list.add(intergrateBoard);
    }

    @Override
    public void visit(PC pc) {
        list.add(pc);
    }

    public int size() {
        return list.size();
    }
}
