package character.util;

public class SkillSet {
    private final Skill[] skills;

    public SkillSet(Skill[] skills) {
        if (skills == null || skills.length == 0) {
            throw new IllegalArgumentException("Skills array cannot be null or empty");
        }
        this.skills = skills;
    }

    public Skill[] getAllSkills() {
        return this.skills;
    }

    public Skill getSkill(int index) {
        if (index >= 0 && index < skills.length) {
            return skills[index];
        }
        return null;
    }

    public int getSkillCount() {
        return skills.length;
    }

    public void displaySkills() {
        System.out.println("┌────────────────────────────────────────────┐");
        for (int i = 0; i < skills.length; i++) {
            System.out.printf("│ [%d] %-38s │%n", i, skills[i]);
        }
        System.out.println("└────────────────────────────────────────────┘");
    }

    // Get a random skill for enemies
    public Skill getRandomSkill() {
        int randomIndex = (int)(Math.random() * skills.length);
        return skills[randomIndex];
    }
}