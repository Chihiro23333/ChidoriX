package com.bilibili.designpatterncomponent.decorate;

public class MaoZi extends ArmDecorator {

    Hero hero;

    public MaoZi(Hero hero) {
        this.hero = hero;
    }

    @Override
    public String getDescription() {
        return hero.getDescription()+"+帽子";
    }

    @Override
    public int ad() {
        return hero.ad() + 0;
    }

    @Override
    public int ap() {
        return hero.ap() + 80;
    }

    @Override
    public int cost() {
        return hero.cost() + 3300;
    }
}
