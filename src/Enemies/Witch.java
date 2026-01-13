package Enemies;

import character.util.Enemy;
import character.util.Skill;
import character.util.SkillSet;

public class Witch extends Enemy {

    public Witch() {
        setHeroName("Witch");
        setMaxHealth(75);
        setMaxMana(120);

        Skill[] skills = {
                new Skill("Curse", 10, 12),
                new Skill("Dark Magic", 20, 28),
                new Skill("Hex Blast", 35, 40)
        };
        setSkillSet(new SkillSet(skills));
    }
}