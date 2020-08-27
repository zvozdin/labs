package patterns.head_first.strategy.gameCharacterTask;

public class Knight extends Character {

    public Knight() {
        weapon = new BowAndArrowBehavior();
    }

    @Override
    void fight() {
        weapon.useWeapon();
    }
}
