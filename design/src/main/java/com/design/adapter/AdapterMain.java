package com.design.adapter;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-16 18:45
 **/
public class AdapterMain {
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();
        WildTurkey turkey = new WildTurkey();

        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        turkey.fly();
        turkey.gobble();

        duck.fly();
        duck.quack();

        turkeyAdapter.fly();
        turkeyAdapter.quack();
    }

}
