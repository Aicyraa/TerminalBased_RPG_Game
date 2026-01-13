package character.util;

public class Enemy extends Character{

    private final static int healthRange = 3;
    private static int randomNumber() { return (int) (Math.random() * healthRange + 1);}

    public void setEnemyHealth(int health){
        setMaxHealth(health * randomNumber());
    }

}
