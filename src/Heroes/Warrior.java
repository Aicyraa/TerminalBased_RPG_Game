package Heroes;
import character.util.Character;

public class Warrior extends Character{

    public Warrior(String user){
        setUser(user);
        setHeroName("Warrior");
        setMaxHealth(100);
    }

    public Object heroDetails(){
        return new Object[]{getUser(), getHeroName(), getMaxHealth()};
    }

}
