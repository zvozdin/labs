package patterns.head_first.strategy.gameCharacterTask;

public class Main {

    public static void main(String[] args) {
        Character character = new King();
        character.fight();
        System.out.println("change weapon");
        character.setWeapon(new AxeBehavior());
        character.fight();
    }
}