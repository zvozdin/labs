package patterns.head_first.strategy.gameCharacterTask;

public abstract class Character {

    protected WeaponBehavior weapon;

    abstract void fight();

    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }
}