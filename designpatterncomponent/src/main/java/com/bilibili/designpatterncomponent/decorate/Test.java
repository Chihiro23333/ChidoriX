package com.bilibili.designpatterncomponent.decorate;

public class Test {

    public static void main(String args[]) {
        Hero mangwan = new MangWan();
        Hero huli = new Huli();

        Hero armMangWan = new XiXueQiang(new MaoZi(new WuJin(mangwan)));
        Hero armHuli = new MaoZi(new WuJin(new XiXueQiang(huli)));

        System.out.println(armMangWan.getDescription()+"cost="+armMangWan.cost()+"ad="+armMangWan.ad()+"ap="+armMangWan.ap());
        System.out.println(armHuli.getDescription()+"cost="+armHuli.cost()+"ad="+armHuli.ad()+"ap="+armHuli.ap());
    }

}
