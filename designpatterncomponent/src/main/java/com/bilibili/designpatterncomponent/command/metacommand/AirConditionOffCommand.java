package com.bilibili.designpatterncomponent.command.metacommand;

public class AirConditionOffCommand implements ICommand {

    private AirCondition airCondition;

    public AirConditionOffCommand(AirCondition airCondition) {
        this.airCondition = airCondition;
    }

    @Override
    public void execute() {
        airCondition.off();
    }

    @Override
    public void undo() {
        airCondition.on();
    }
}
