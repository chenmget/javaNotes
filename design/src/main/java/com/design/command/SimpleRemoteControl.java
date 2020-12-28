package com.design.command;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-12 19:11
 **/
public class SimpleRemoteControl {
    Command slot;
    public void setCommand(Command command){
        this.slot = command;
    }
    public void buttonWasPressed(){
        slot.execute();
    }
}
