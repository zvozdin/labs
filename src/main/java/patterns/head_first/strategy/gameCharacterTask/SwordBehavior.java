package patterns.head_first.strategy.gameCharacterTask;

public class SwordBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("I'm strike with the Sword");
    }
}