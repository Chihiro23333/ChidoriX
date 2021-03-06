package com.bilibili.designpatterncomponent.command.simplecommand;

public class SimpleRemoteControl {

    private ICommand command;

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void buttonPressed(){
        command.execute();
    }
}
