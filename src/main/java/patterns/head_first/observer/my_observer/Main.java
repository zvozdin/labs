package patterns.head_first.observer.my_observer;

import lombok.SneakyThrows;

import static java.lang.Thread.sleep;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        Subject weather = new WeatherDataSubjectImpl();
        Observer currentCondition = new CurrentConditionsDisplay(weather);
        Observer heatIndex = new HeatIndexDisplay(weather);

        ((WeatherDataSubjectImpl) weather).setMeasurements(80, 65, 30.4f);

        sleep(2000);

        ((WeatherDataSubjectImpl) weather).setMeasurements(85, 80, 25.4f);
    }
}
