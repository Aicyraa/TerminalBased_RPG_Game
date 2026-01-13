package Enemies;
import character.util.Enemy;
import character.util.Skill;
import character.util.SkillSet;

public class DeadWarrior extends Enemy {

    public DeadWarrior() {
        setHeroName("Dead Warrior");
        setEnemyHealth(100);
        setMaxMana(60);

        Skill[] skills = {
                new Skill("Bone Crush", 8, 12),
                new Skill("Death Grip", 15, 18),
                new Skill("Soul Drain", 20, 25)
        };
        setSkillSet(new SkillSet(skills));
    }
}