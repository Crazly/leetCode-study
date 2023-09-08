package com.study.example.leetcodestudy.designer.observer;

import java.util.Observable;

public interface Observer {
    void update(float temp, float humidity,float pressure);
}
