package character.util;

public class SkillSet {

    private final Skill[] skills;

    public SkillSet(Skill[] skills) {
        this.skills = skills;
    }

    public Skill[] getAllSkill(){
        return this.skills;
    }

    public Skill getSkill(int index) {
        if (index >= 0  && index < skills.length) {
            return skills[index];
        }

        return null;
    }



    public void displaySkills() {
        for (Skill skill : skills) {
            System.out.println("* " + skill);
        }
    }
}
