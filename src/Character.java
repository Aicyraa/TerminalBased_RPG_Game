class Character {
         String name;
        int maxHealth;
        int currentHealth = maxHealth;


        void setName(String name) {
            this.name = name;
        }

        void setMaxHealth(int health){
            this.maxHealth = health;
        }

        void setDamage(int damage) {
            this.currentHealth = this.currentHealth - damage;
        }

        String isAlive() {
             if (this.currentHealth == 0) {
                 return "You Died!";
             } else {
                 return "";
             }
        }

}
