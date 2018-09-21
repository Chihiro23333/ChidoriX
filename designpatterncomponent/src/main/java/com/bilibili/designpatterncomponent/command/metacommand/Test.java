package com.bilibili.designpatterncomponent.command.metacommand;

public class Test {
    public static void main(String[] args){
        RemoteControl remoteControl  = new RemoteControl();

        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        AirCondition airCondition  = new AirCondition();
        AirConditionOnCommand airConditionOnCommand  = new AirConditionOnCommand(airCondition);
        AirConditionOffCommand airConditionOffCommand = new AirConditionOffCommand(airCondition);

        ICommand[] onCommand = {airConditionOnCommand ,lightOnCommand};
        ICommand[] offCommand = {airConditionOffCommand ,lightOffCommand};
        PartyCommand partyOnCommand = new PartyCommand(onCommand);
        PartyCommand partyOffCommand = new PartyCommand(offCommand);

        remoteControl.setCommand(0 ,lightOnCommand ,lightOffCommand);
        remoteControl.setCommand(1 ,airConditionOnCommand ,airConditionOffCommand);
        remoteControl.setCommand(2,partyOnCommand ,partyOffCommand);

        remoteControl.onPressed(0);
        remoteControl.offPressed(1);
        remoteControl.onPressed(2);

        remoteControl.undoPressed();
    }
}
