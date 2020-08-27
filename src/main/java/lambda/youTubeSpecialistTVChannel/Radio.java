package lambda.youTubeSpecialistTVChannel;

public class Radio implements ElectricityConsumer {

    public void playMusic() {
        System.out.println("Music is playing");
    }

    @Override
    public void electricityOn() {
        playMusic();
    }
}
