package Heroes;
import character.util.Character;
import character.util.Skill;
import character.util.SkillSet;

public class Warrior extends Character{


    public Warrior(String user) {
        setUser(user);
        setHeroName("Warrior");
        setMaxHealth(120);
        setMaxMana(80);

        Skill[] skills = {
                new Skill("Sword Slash", 10, 15),
                new Skill("Shield Bash", 15, 20),
                new Skill("Berserker Rage", 25, 35)
        };
        setSkillSet(new SkillSet(skills));
    }

}
