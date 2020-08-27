package patterns.head_first.observer.java_util_observer;

import patterns.head_first.observer.my_observer.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {

    private Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof WeatherDataObservableImpl) {
            WeatherDataObservableImpl weather = (WeatherDataObservableImpl) observable;
            temperature = weather.getTemperature();
            humidity = weather.getHumidity();
            display();
        }

        if (arg instanceof WeatherDataObservableImpl) {
            WeatherDataObservableImpl dataObservable = (WeatherDataObservableImpl) arg;
            System.out.println(dataObservable.getTemperature() + " : " + dataObservable.getHumidity());
        }
    }

    @Override
    public void display() {
        System.out.println(String
                .format("Current conditions: %.2f F degrees and %.2f humidity",
                        temperature, humidity));

    }
}