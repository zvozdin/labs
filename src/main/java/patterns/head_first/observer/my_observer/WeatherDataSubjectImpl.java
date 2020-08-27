package patterns.head_first.observer.my_observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataSubjectImpl implements Subject {

    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    private float temp;

    public WeatherDataSubjectImpl() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(temperature, humidity, pressure));
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}