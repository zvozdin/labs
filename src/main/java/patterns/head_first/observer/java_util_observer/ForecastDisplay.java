package patterns.head_first.observer.java_util_observer;

import patterns.head_first.observer.my_observer.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {

    private float currentPressure = 29.92f;
    private float lastPressure;

    public ForecastDisplay(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof WeatherDataObservableImpl) {
            WeatherDataObservableImpl weather = (WeatherDataObservableImpl) observable;
            lastPressure = currentPressure;
            currentPressure = weather.getPressure();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println(String
                .format("Current conditions: %.2f was and %.2f now",
                        lastPressure, currentPressure));
    }
}