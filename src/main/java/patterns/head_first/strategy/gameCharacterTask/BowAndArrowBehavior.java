package patterns.head_first.strategy.gameCharacterTask;

public class BowAndArrowBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("I'm shot with Arrow from Bow");
    }
}