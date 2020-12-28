package com.design.command;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-12 19:09
 **/
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
