package character.util;

public class Randomizer {

    // health randomizer
    // attack randomizer

    static int randomNumber(int value) {
        return (int) (Math.random() * value + 1);
    }

    public int generateEnemyHealth(int health){
        return health * randomNumber(3);
    }

}
