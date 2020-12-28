package com.design.template;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-19 18:46
 **/
public class TemplateMain {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
