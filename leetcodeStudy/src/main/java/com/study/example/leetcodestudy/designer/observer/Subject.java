package com.study.example.leetcodestudy.designer.observer;


public interface Subject {

    public void registerObserver(Observer ob);
    public void removeObserver(Observer ob);
    public void notifyObserver(Observer ob);

}
