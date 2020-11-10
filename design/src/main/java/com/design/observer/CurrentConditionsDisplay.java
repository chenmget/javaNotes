package com.design.observer;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-09 19:02
 **/
public class CurrentConditionsDisplay implements Observer,DisplayElement {
    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    @Override
    public void display() {
        System.out.println("current temperature: " +temperature+", and humidity: "+humidity);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
}
