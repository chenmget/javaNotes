package com.design.template;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-19 18:46
 **/
public class Football extends  Game {
    @Override
    void initialize() {
        System.out.println("Football initialize");
    }

    @Override
    void startPlay() {
        System.out.println("Football startPlay");
    }

    @Override
    void endPlay() {
        System.out.println("Football endPlay");
    }
}
