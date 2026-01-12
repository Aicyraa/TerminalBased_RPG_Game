package character.util;

public class Character {
        String user;
        String heroName;
        int maxHealth;
        int currentHealth;

        public void setUser(String user) {this.user = user; }
        public void setHeroName(String name) { this.heroName = name; }
        public void setMaxHealth(int health) { this.maxHealth = health; this.currentHealth = this.maxHealth; }

        public String getUser() { return this.user; }
        public String getHeroName() { return this.heroName; }
        public String getMaxHealth() { return String.valueOf(this.maxHealth); }

        public void setDamage(int damage) { this.currentHealth = this.currentHealth - damage; }
}
