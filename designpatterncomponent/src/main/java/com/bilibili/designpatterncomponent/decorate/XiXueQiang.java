package com.bilibili.designpatterncomponent.decorate;

public class XiXueQiang extends ArmDecorator {

    Hero hero;

    public XiXueQiang(Hero hero) {
        this.hero = hero;
    }

    @Override
    public String getDescription() {
        return hero.getDescription() +"+吸血枪";
    }

    @Override
    public int ad() {
        return hero.ad() + 20;
    }

    @Override
    public int ap() {
        return hero.ap() +25;
    }

    @Override
    public int cost() {
        return hero.cost() + 2800;
    }
}
