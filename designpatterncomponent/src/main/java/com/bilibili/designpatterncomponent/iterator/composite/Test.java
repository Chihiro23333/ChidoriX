package com.bilibili.designpatterncomponent.iterator.composite;

public class Test {

    public static void main(String args[]) {
        MenuComponent allMenus = new Menu("总菜单", "总汇");

        MenuComponent meatMenu = new Menu("肉菜", "贵");
        MenuComponent pig = new MenuItem("猪肉炖粉条", "猪肉+粉条");
        MenuComponent beef = new MenuItem("小炒黄牛肉", "牛肉+辣椒");
        meatMenu.addChild(pig);
        meatMenu.addChild(beef);

        MenuComponent vgMenu = new Menu("素菜", "便宜");
        MenuComponent baicai = new MenuItem("清炒小白菜", "小白菜");
        MenuComponent youmaicai = new MenuItem("清炒油麦菜", "油麦菜");
        vgMenu.addChild(baicai);
        vgMenu.addChild(youmaicai);

        allMenus.addChild(meatMenu);
        allMenus.addChild(vgMenu);

        Waitress waitress = new Waitress(allMenus);
        waitress.print();
    }

}
