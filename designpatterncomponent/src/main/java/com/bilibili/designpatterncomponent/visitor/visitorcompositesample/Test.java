package com.bilibili.designpatterncomponent.visitor.visitorcompositesample;

public class Test {
    public static void main(String args[]) {

        PriceVisitor priceVisitor = new PriceVisitor();
        SizeVisitor sizeVisitor = new SizeVisitor();

        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.add(new MainBoard());
        objectStructure.add(new HardDisk());
        objectStructure.add(new IntergrateBoard());

        objectStructure.visit(priceVisitor);
        System.out.println("总价格是:" + priceVisitor.price());

        objectStructure.visit(sizeVisitor);
        System.out.println("总个数是:" + sizeVisitor.size());
    }
}
