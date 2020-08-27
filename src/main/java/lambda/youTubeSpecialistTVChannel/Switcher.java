package lambda.youTubeSpecialistTVChannel;

import java.util.ArrayList;
import java.util.List;

public class Switcher {

    private List<ElectricityConsumer> consumers;

    public Switcher() {
        consumers = new ArrayList<>();
    }

    public void switchOn() {
        System.out.println("electricity on");
        for (ElectricityConsumer consumer : consumers) {
            consumer.electricityOn();
        }
    }

    public void addConsumers(ElectricityConsumer consumer) {
        consumers.add(consumer);
    }
}
