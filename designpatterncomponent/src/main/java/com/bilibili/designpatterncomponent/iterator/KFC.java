package com.bilibili.designpatterncomponent.iterator;

public class KFC implements Resterant{
    private MenuItem[] menuItems;
    private static final int MAX_LENGTH = 6;
    private int curPosition = 0;

    public KFC() {
        menuItems = new MenuItem[MAX_LENGTH];

        addItem("香辣鸡腿堡", "16");
        addItem("田园鸡腿堡", "30");
        addItem("圣代", "6");
    }

    public void addItem(String name, String price) {
        if (curPosition >= MAX_LENGTH) {
            System.out.println("菜单已经到达最大长度");
        } else {
            MenuItem menuItem = new MenuItem(name, price);
            menuItems[curPosition] = menuItem;
            curPosition++;
        }
    }

    public Iterator createIterator() {
        return new KFCIterator(menuItems);
    }
}
