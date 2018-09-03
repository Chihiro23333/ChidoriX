package com.bilibili.designpatterncomponent.metacommand;

public class NoCommand implements ICommand {
    @Override
    public void execute() {
        System.out.println("execute空命令");
    }

    @Override
    public void undo() {
        System.out.println("undo空命令");
    }
}
