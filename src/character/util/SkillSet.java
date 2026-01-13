package character.util;

public class SkillSet {

    private Skill[] skills;

    public SkillSet(Skill[] skills) { this.skills = skills; }

    public Skill[] getAllSkill() {
        return skills;
    }

    public int getSKillCount(){
        return skills.length;
    }

    public Skill getSkill(int index) {
        if (index >= 0  && index < skills.length) {
            return skills[index];
        }

        return null;
    }

    public void displaySkills() {
        for (Skill skill : skills) {
            System.out.print(skill);
        }
    }
}
