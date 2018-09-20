package com.bilibili.designpatterncomponent.iterator;

import java.util.ArrayList;
import java.util.List;

public class Mcdonalds implements Resterant{

    private List<MenuItem> menuItemList;

    public Mcdonalds() {
        menuItemList = new ArrayList<>();

        addItem("巨无霸套餐","32");
        addItem("培根叔萃双层牛堡","28");
        addItem("新地","6");
    }

    public void addItem(String name ,String price){
        MenuItem menuItem = new MenuItem(name ,price);
        menuItemList.add(menuItem);
    }

    public Iterator createIterator(){
        return new MicdonaldsIterator(menuItemList);
    }
}
