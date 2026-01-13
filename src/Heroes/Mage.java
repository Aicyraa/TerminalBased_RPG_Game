package Heroes;

import character.util.Character;
import character.util.Skill;
import character.util.SkillSet;

public class Mage extends Character {

    public Mage(String user) {
        setUser(user);
        setHeroName("Mage");
        setMaxHealth(70);
        setMaxMana(150);

        Skill[] skills = {
                new Skill("Fireball", 15, 25),
                new Skill("Lightning Bolt", 25, 35),
                new Skill("Meteor Storm", 50, 60)
        };
        setSkillSet(new SkillSet(skills));
    }
}