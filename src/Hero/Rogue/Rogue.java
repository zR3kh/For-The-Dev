package Hero.Rogue;

import Hero.Hero;

public class Rogue extends Hero {

    public Rogue(String name) {
        super(name);
        this.life = 30;
        this.maxLife = 30;
        this.energy = 10;
        this.maxEnergy = 10;
        this.strength = 8;
        this.intelligence = 5;
        this.speed = 15;
    }
}
