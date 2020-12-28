package com.design.template;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-19 18:45
 **/
public class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket initialize");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket startPlay");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket endPlay");
    }
}
