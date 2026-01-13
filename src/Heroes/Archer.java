
package Heroes;
import character.util.Character;
import character.util.Skill;
import character.util.SkillSet;

public class Archer extends Character {

    public Archer(String user) {
        setUser(user);
        setHeroName("Archer");
        setMaxHealth(80);
        setMaxMana(100);

        Skill[] skills = {
                new Skill("Arrow Shot", 8, 12),
                new Skill("Multi-Shot", 18, 25),
                new Skill("Sniper Shot", 30, 45)
        };
        setSkillSet(new SkillSet(skills));
    }
}