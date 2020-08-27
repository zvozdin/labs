package patterns.head_first.strategy.gameCharacterTask;

public class King extends Character {

    public King() {
        weapon = new SwordBehavior();
    }

    @Override
    void fight() {
        weapon.useWeapon();
    }
}