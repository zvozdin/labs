package patterns.head_first.strategy.duckSimulator;

public class MiniDuckSimulator {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        System.out.println("======================");

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();

        System.out.println("======================");

        HunterDuckDecoy hunter = new HunterDuckDecoy();
        hunter.decoy();
        hunter.setQuackBehavior(new Squeak());
        hunter.decoy();
    }
}