package lambda.youTubeSpecialistTVChannel;

public class Lamp implements ElectricityConsumer {

    public void lightOn() {
        System.out.println("lamp light on");
    }

    @Override
    public void electricityOn() {
        lightOn();
    }
}
