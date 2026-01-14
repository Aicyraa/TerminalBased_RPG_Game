package character.util;

public class Character {
        protected String user;
        protected String heroName;
        protected int maxHealth;
        protected int currentHealth;
        protected int maxMana;
        protected int currentMana;
        protected SkillSet skillSet;

        // Setters
        public void setUser(String user) {
                this.user = user;
        }

        public void setCharacterName(String name) {
                this.heroName = name;
        }

        public void setMaxHealth(int health) {
                this.maxHealth = health;
                this.currentHealth = health;
        }

        public void setMaxMana(int mana) {
                this.maxMana = mana;
                this.currentMana = mana;
        }

        public void setSkillSet(SkillSet skillSet) {
                this.skillSet = skillSet;
        }

        // Battle mechanics
        public void setDamage(int damage) {
                this.currentHealth = Math.max(0, this.currentHealth - damage);
        }

        public void setMana(int cost) {
                if (this.currentMana >= cost) {
                        this.currentMana -= cost;
                }
        }

        public void restoreAfterBattle() {
                // Restore 30% health and 50% mana after winning
                this.currentHealth = Math.min(this.maxHealth,
                        this.currentHealth + (int)(this.maxHealth * 0.3));
                this.currentMana = Math.min(this.maxMana,
                        this.currentMana + (int)(this.maxMana * 0.5));

                System.out.println("🌟 Restored health and mana!");
        }

        public boolean isAlive() {
                return this.currentHealth > 0;
        }

        // Getters
        public String getUser() {
                return this.user;
        }

        public String getCharacterName() {
                return this.heroName;
        }

        public int getMaxHealth() {
                return this.maxHealth;
        }

        public int getCurrentHealth() {
                return this.currentHealth;
        }

        public int getMaxMana() {
                return this.maxMana;
        }

        public int getCurrentMana() {
                return this.currentMana;
        }

        public SkillSet getSkillSet() {
                return this.skillSet;
        }

        public void getAllDetails() {
                System.out.println("👤 User: " + getUser());
                System.out.println("⚔️ Hero: " + getCharacterName());
                System.out.println("❤️ Health: " + getCurrentHealth() + "/" + getMaxHealth());
                System.out.println("🔵 Mana: " + getCurrentMana() + "/" + getMaxMana());
                System.out.println("\n⚡ Skills:");
                getSkillSet().displaySkills();
        }

        // Calculate damage with potential for critical hits
        public int calculateDamage(Skill skill) {
                int baseDamage = skill.getDamage();
                // 20% chance for critical hit (1.5x damage)
                if (Math.random() < 0.2) {
                        System.out.println("💫 CRITICAL HIT!");
                        return (int)(baseDamage * 1.5);
                }
                return baseDamage;
        }
}