package patterns.head_first.observer.java_util_observer;

import lombok.SneakyThrows;

import java.util.Observer;

import static java.lang.Thread.sleep;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        WeatherDataObservableImpl weather = new WeatherDataObservableImpl();
        Observer condition = new CurrentConditionDisplay(weather);
        Observer forecast = new ForecastDisplay(weather);

        weather.setMeasurements(80, 65, 30.4f);

        sleep(2000);

        weather.setMeasurements(85, 80, 25.4f);
    }
}
