package com.study.example.leetcodestudy.designer.observer;

import java.util.Observable;
import java.util.Observer;

public class ForeCastDisplay implements Observer,DisplayElement {

    private float currentPressure=29.92f;
    private float lastPressure;

    public ForeCastDisplay(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("currentPressure:"+currentPressure+"lastPressure:"+lastPressure);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData o1 = (WeatherData) o;
            lastPressure= currentPressure;
            currentPressure=o1.getPressure();
            display();
        }
    }
}
