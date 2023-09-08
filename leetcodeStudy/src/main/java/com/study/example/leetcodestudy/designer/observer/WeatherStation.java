package com.study.example.leetcodestudy.designer.observer;

public class WeatherStation {

    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();

        ForeCastDisplay foreCastDisplay = new ForeCastDisplay(weatherData);
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);



        weatherData.setMeasurements(10,12,13);
        weatherData.setMeasurements(20,22,23);
        weatherData.setMeasurements(30,32,33);

//        currentConditionDisplay.update();



    }


}
