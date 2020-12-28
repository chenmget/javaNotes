package com.design.command;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-12 19:13
 **/
public class CommandMain {


    public static void main(String[] args) {
        Light light = new Light();
        SimpleRemoteControl remote = new SimpleRemoteControl();
        LightOnCommand lc = new LightOnCommand(light);
        remote.setCommand(lc);
        remote.buttonWasPressed();
    }

}
