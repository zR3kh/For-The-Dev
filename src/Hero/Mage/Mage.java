package Hero.Mage;

import Hero.Hero;

public class Mage extends Hero {

    public Mage(String name) {
        super(name);
        this.life = 20;
        this.maxLife = 20;
        this.energy = 30;
        this.maxEnergy = 30;
        this.strength = 5;
        this.intelligence = 20;
        this.speed = 5;
    }
}
