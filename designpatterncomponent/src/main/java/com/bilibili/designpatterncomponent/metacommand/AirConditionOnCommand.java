package com.bilibili.designpatterncomponent.metacommand;

public class AirConditionOnCommand implements ICommand {

    private AirCondition airCondition;

    public AirConditionOnCommand(AirCondition airCondition) {
        this.airCondition = airCondition;
    }

    @Override
    public void execute() {
        airCondition.on();
    }

    @Override
    public void undo() {
        airCondition.off();
    }
}
