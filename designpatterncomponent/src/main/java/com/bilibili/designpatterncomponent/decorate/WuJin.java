package com.bilibili.designpatterncomponent.decorate;

public class WuJin extends ArmDecorator {

    private Hero hero;

    public WuJin(Hero hero) {
        this.hero = hero;
    }

    @Override
    public String getDescription() {
        return hero.getDescription() + "+无尽之刃";
    }

    @Override
    public int ad() {
        return hero.ad() + 60;
    }

    @Override
    public int ap() {
        return hero.ap()+ 0;
    }

    @Override
    public int cost() {
        return hero.cost() + 3000;
    }
}
