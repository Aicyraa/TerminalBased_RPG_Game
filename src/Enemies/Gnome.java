package Enemies;
import character.util.Enemy;
import character.util.Skill;
import character.util.SkillSet;

public class Gnome extends Enemy {

    public Gnome() {
        setCharacterName("Gnome");
        setEnemyHealth(60);
        setMaxMana(80);

        Skill[] skills = {
                new Skill("Bite", 5, 8),
                new Skill("Poison Dart", 12, 15),
                new Skill("Trap Strike", 18, 22)
        };
        setSkillSet(new SkillSet(skills));
    }
}