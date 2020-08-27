package patterns.head_first.strategy.gameCharacterTask;

public class Queen extends Character {

    public Queen() {
        weapon = new KnifeBehavior();
    }

    @Override
    void fight() {
        weapon.useWeapon();
    }
}