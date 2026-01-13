package character.util;

public class Skillset {

    private Skill[] skills;

    public Skillset(Skill[] skills){
        this.skills = skills;
    }

    public Skill getSkill(int index) {
        if (index >= 0  && index < skills.length) {
            return skills[index];
        }

        return null;
    }

    public Skill[] getAllSkill() {
        return skills;
    }

    public int getSKillCount(){
        return skills.length;
    }

    public void displaySkills() {
        for (Skill skill : skills) {
            System.out.print(skill);
        }
    }
}
