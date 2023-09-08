package com.study.example.leetcodestudy.designer.observer;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay implements Observer,DisplayElement {

    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current Conditions: 温度="+temperature+" 湿度："+humidity);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData o1 = (WeatherData) o;
             this.temperature = o1.getTemperature();
            this.humidity= o1.getHumidity();
            display();
        }
    }
}
