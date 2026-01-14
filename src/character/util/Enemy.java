package character.util;

import Enemies.DeadWarrior;
import Enemies.Gnome;
import Enemies.Orc;
import Enemies.Witch;

public class Enemy extends Character {
    private static final int HEALTH_MULTIPLIER_MIN = 1;
    private static final int HEALTH_MULTIPLIER_MAX = 2;

    private static int randomNumber(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }

    public void setEnemyHealth(int baseHealth) {
        int multiplier = randomNumber(HEALTH_MULTIPLIER_MIN, HEALTH_MULTIPLIER_MAX);
        setMaxHealth(baseHealth * multiplier);
    }

    public Enemy getEnemy() {
        int enemyType = randomNumber(1, 4);

        return switch (enemyType) {
            case 1 -> new DeadWarrior();
            case 2 -> new Gnome();
            case 3 -> new Orc();
            case 4 -> new Witch();
            default -> throw new IllegalStateException("Unexpected enemy type: " + enemyType);
        };
    }

    public Skill getRandomSkill() {
        if (skillSet == null) {
            throw new IllegalStateException("SkillSet not initialized for enemy");
        }
        return skillSet.getRandomSkill();
    }

    @Override
    public void restoreAfterBattle() {
        // Enemies don't restore after battle
    }
}