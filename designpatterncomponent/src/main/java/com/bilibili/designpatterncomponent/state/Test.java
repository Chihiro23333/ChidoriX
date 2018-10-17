package com.bilibili.designpatterncomponent.state;

public class Test {

    public static void main(String args[]) {

        GunballMachine gunballMachine = new GunballMachine(2);

        gunballMachine.insertQuarter();
        gunballMachine.turnCrank();

        gunballMachine.insertQuarter();
        gunballMachine.turnCrank();

        gunballMachine.insertQuarter();
        gunballMachine.turnCrank();
    }

}
