package Enemies;

import character.util.Enemy;
import character.util.Skill;
import character.util.SkillSet;

public class Orc extends Enemy {

    public Orc() {
        setHeroName("Orc");
        setMaxHealth(130);
        setMaxMana(50);

        Skill[] skills = {
                new Skill("Club Smash", 10, 18),
                new Skill("War Cry", 15, 22),
                new Skill("Rampage", 25, 35)
        };
        setSkillSet(new SkillSet(skills));
    }
}