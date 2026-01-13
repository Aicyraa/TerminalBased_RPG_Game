package character.util;

public class Skill {
    private String name;
    private int manaCost;
    private int damage;

    public Skill(String name, int manaCost, int damage){
        this.name = name;
        this.manaCost = manaCost;
        this.damage = damage;
    }

    public String getName() {return this.name; }
    public int getMana() {return this.manaCost; }
    public int getDamage() {return this.damage; }

    @Override
    public String toString() {
        return name + " (Mana: " + manaCost + ", Damage: " + damage + ")";
    }
}

