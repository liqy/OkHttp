package com.liqy.okhttp.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqy on 2018/3/7.
 */

public class Weather implements Observable{

    List<Observer> observers;

    public Weather() {
        this.observers=new ArrayList<>();
    }

    @Override
    public void subscribe(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void unSubscribe(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notify(String data) {
        for (Observer observer: observers) {
            observer.update(data);
        }
    }
}
