package Character;

public class Character {
        String name;
        int maxHealth;
        int currentHealth = maxHealth;

        public void setName(String name) { this.name = name; }
        public void setMaxHealth(int health) { this.maxHealth = health; }

        public void setDamage(int damage) { this.currentHealth = this.currentHealth - damage; }

}
