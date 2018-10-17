package com.bilibili.designpatterncomponent.state;

public class HasQuarterState implements State {

    private GunballMachine gunballMachine;

    public HasQuarterState(GunballMachine gunballMachine) {
        this.gunballMachine = gunballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("没摇曲柄只能收一次钱");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("ejectQuarter");
        gunballMachine.setCurState(gunballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {

        System.out.println("turnCrank");

        gunballMachine.setCurState(gunballMachine.getSoldState());

    }

    @Override
    public void dispense() {

        System.out.println("等待购买");

    }
}
