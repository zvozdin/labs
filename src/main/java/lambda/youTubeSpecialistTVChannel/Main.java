package lambda.youTubeSpecialistTVChannel;

//  https://www.youtube.com/watch?v=DNC6Lknn2AE
public class Main {

    public static void main(String[] args) {
        Switcher switcher = new Switcher();

//        event subscribe
//        switcher.consumers = lamp;

        switcher.addConsumers(new Lamp());
        switcher.addConsumers(new Radio());

        switcher.addConsumers(new ElectricityConsumer() {
            @Override
            public void electricityOn() {
                System.out.println("tv is showing");
            }
        });

        switcher.addConsumers(() -> System.out.println("lambda is showing"));


//        switcher.addConsumers(new Main()::fire);

        switcher.addConsumers(Main::fire);

        switcher.switchOn();
//    switcher.addConsumers(() -> Main.fire());
    }
//        |  when static
//       \|/
    public static void fire() {
        System.out.println("fire!!!");
    }

//    when non-static
//    public void fire() {
//        System.out.println("fire!!!");
//    }
}
