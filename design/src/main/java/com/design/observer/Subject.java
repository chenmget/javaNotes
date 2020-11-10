package com.design.observer;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-09 18:42
 **/
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
