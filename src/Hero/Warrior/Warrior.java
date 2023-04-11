package Hero.Warrior;

import Hero.Hero;

public class Warrior extends Hero {

    public Warrior(String name) {
        super(name);
        this.life = 30;
        this.maxLife = 30;
        this.energy = 10;
        this.maxEnergy = 10;
        this.strength = 10;
        this.intelligence = 5;
        this.speed = 5;
    }
}
