
package Heroes;
import character.util.Character;
import character.util.Skill;
import character.util.SkillSet;

public class Assassin extends Character {

    public Assassin(String user) {
        setUser(user);
        setCharacterName("Assassin");
        setMaxHealth(90);
        setMaxMana(110);

        Skill[] skills = {
                new Skill("Backstab", 12, 20),
                new Skill("Shadow Strike", 20, 30),
                new Skill("Assassinate", 35, 50)
        };
        setSkillSet(new SkillSet(skills));
    }
}