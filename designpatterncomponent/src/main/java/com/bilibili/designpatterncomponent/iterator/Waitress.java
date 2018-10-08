package com.bilibili.designpatterncomponent.iterator;

public class Waitress {

    private Resterant kfc;
    private Resterant mcdonalds;

    public Waitress(Resterant kfc, Resterant mcdonalds) {
        this.kfc = kfc;
        this.mcdonalds = mcdonalds;
    }

    public void printAllMenu() {
        Iterator iterator = kfc.createIterator();
        Iterator iterator1 = mcdonalds.createIterator();
        print(iterator);
        print(iterator1);
    }

    private void print(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem next = iterator.next();
            System.out.println("name:" + next.getName() + "--" + "price:" + next.getPrice());
        }
    }
}
