package Heroes;
import character.util.Character;

public class Archer extends Character {

    public Archer(String user){
        setUser(user);
        setHeroName("Warrior");
        setMaxHealth(100);
    }

    public Object heroDetails(){
        return new Object[]{getUser(), getHeroName(), getMaxHealth()};
    }

}