package com.bilibili.designpatterncomponent.command.metacommand;

public class RemoteControl {

    private ICommand[] onCommands;
    private ICommand[] offCommands;

    private ICommand noCommand;

    private ICommand undoCommand;

    public RemoteControl() {
        onCommands = new ICommand[3];
        offCommands = new ICommand[3];
        noCommand = new NoCommand();

        for (int i = 0; i < 3; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }

        undoCommand = noCommand;
    }


    public void setCommand(int position ,ICommand onCommand ,ICommand offCommand){
        onCommands[position] = onCommand;
        offCommands[position] = offCommand;
    }

    public void onPressed(int position){
        onCommands[position].execute();
        undoCommand = onCommands[position];
    }

    public void offPressed(int position){
        offCommands[position].execute();
        undoCommand = offCommands[position];
    }

    public void undoPressed(){
        undoCommand.undo();
    }

}
