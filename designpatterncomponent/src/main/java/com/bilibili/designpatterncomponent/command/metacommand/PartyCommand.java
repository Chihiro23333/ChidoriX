package com.bilibili.designpatterncomponent.command.metacommand;

public class PartyCommand implements ICommand {

    private ICommand[] iCommands;

    public PartyCommand(ICommand[] iCommands) {
        this.iCommands = iCommands;
    }

    @Override
    public void execute() {
        for (int i = 0; i < iCommands.length; i++) {
            iCommands[i].execute();
        }
    }

    @Override
    public void undo() {
        for (int i = 0; i < iCommands.length; i++) {
            iCommands[i].undo();
        }
    }
}
