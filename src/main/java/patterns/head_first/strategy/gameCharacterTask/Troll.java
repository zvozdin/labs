package patterns.head_first.strategy.gameCharacterTask;

public class Troll extends Character {

    public Troll() {
        weapon = new AxeBehavior();
    }

    @Override
    void fight() {
        weapon.useWeapon();
    }
}