package com.bilibili.designpatterncomponent.observer;

import java.util.ArrayList;
import java.util.List;

public class Weather implements Subject {

    private List<Observer> observers;

    private String temperature;

    public Weather() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(this, temperature);
        }
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}
