package com.bilibili.designpatterncomponent.simplecommand;

public class Test {
    public static void main(String[] args){
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        simpleRemoteControl.setCommand(lightOnCommand);
        simpleRemoteControl.buttonPressed();

        simpleRemoteControl.setCommand(lightOffCommand);
        simpleRemoteControl.buttonPressed();
    }
}
