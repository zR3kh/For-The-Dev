package Hero.Warrior;

import Hero.Hero;

public class Warrior extends Hero {

    public Warrior(String name) {
        super(name);
        this.life = 40;
        this.maxLife = 40;
        this.energy = 10;
        this.maxEnergy = 10;
        this.strength = 12;
        this.intelligence = 5;
        this.speed = 6;
    }
}
