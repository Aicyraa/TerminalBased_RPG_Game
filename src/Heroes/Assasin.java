package Heroes;
import character.util.Character;

class Assasin extends Character {

    public Assasin(String user){
        setUser(user);
        setHeroName("Warrior");
        setMaxHealth(100);
    }

    public Object heroDetails(){
        return new Object[]{getUser(), getHeroName(), getMaxHealth()};
    }

}