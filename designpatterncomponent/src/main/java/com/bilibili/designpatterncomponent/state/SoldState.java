package com.bilibili.designpatterncomponent.state;

public class SoldState implements State {

    private GunballMachine gunballMachine;

    public SoldState(GunballMachine gunballMachine) {
        this.gunballMachine = gunballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("还没结束,不能塞钱");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("还没结束,不能退钱");
    }

    @Override
    public void turnCrank() {
        System.out.println("还已经转动过了");
    }

    @Override
    public void dispense() {
        if (gunballMachine.getCount() > 0) {
            System.out.println("成功售出一颗糖果");
            gunballMachine.releaseBall();
            gunballMachine.setCurState(gunballMachine.getNoQuarterState());
        } else {
            gunballMachine.setCurState(gunballMachine.getSoldOutState());
        }
    }
}
