package character.util;

public class Character {
        protected String user;
        protected String heroName;
        protected int maxHealth;
        protected int currentHealth;
        protected int maxMana;
        protected int currentMana;
        protected SkillSet skillSet;

        public void setUser(String user) {
                this.user = user;
        }

        public void setHeroName(String name) {
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

        public void setSkillSet(SkillSet skillSet ) {
                this.skillSet = skillSet;
        }

        public void setDamage(int damage) {
                this.currentHealth = Math.max(0, this.currentHealth - damage);
        }

        public boolean useMana(int cost) {
                if (currentMana >= cost) {
                        currentMana -= cost;
                        return true;
                }
                return false;
        }

        public String getUser() { return this.user; }
        public String getHeroName() { return this.heroName; }
        public String getMaxHealth() { return String.valueOf(this.maxHealth); }
        public int getCurrentHealth() { return this.currentHealth; }
        public int getCurrentMana() { return this.currentMana; }
        public SkillSet getSkillSet() { return this.skillSet; }

}

