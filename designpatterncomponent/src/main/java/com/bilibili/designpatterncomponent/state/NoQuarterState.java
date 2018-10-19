package com.bilibili.designpatterncomponent.state;

public class NoQuarterState implements State {

    private GunballMachine gunballMachine;

    public NoQuarterState(GunballMachine gunballMachine) {
        this.gunballMachine = gunballMachine;
    }

    @Override
    public void insertQuarter() {
        if (gunballMachine.getCount() > 0) {
            System.out.println("insertQuarter");
            gunballMachine.setCurState(gunballMachine.getHasQuarterState());
        } else {
            gunballMachine.setCurState(gunballMachine.getSoldOutState());
        }
    }

    @Override
    public void ejectQuarter() {
        System.out.println("没钱无法退钱");
    }

    @Override
    public void turnCrank() {
        System.out.println("没钱转动曲柄无效");
    }

    @Override
    public void dispense() {
        System.out.println("没钱无法发放糖果");
    }
}
