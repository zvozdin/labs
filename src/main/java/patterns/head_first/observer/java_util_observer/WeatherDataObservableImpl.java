package patterns.head_first.observer.java_util_observer;

import lombok.Getter;

import java.util.Observable;

@Getter
public class WeatherDataObservableImpl extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    public void measurementsChanged() {
        setChanged();
        notifyObservers(this);
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}