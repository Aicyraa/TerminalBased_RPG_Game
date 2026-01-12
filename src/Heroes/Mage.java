package Heroes;
import character.util.Character;

public class Mage extends Character {

    public Mage(String user){
        setUser(user);
        setHeroName("Mage");
        setMaxHealth(50);
    }

    public Object heroDetails(){
        return new Object[]{getUser(), getHeroName(), getMaxHealth()};
    }

}