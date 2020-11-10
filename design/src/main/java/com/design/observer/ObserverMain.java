package com.design.observer;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-09 19:09
 **/
public class ObserverMain {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay display = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(1,2,3);
    }
}
