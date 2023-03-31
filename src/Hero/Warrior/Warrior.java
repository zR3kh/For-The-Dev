package Hero.Warrior;

import Hero.Hero;
import Weapon.Sword.Sword;

public class Warrior extends Hero {

    public Warrior(String name) {
        super(name);
        this.life = 15;
        this.maxLife = 15;
        this.energy = 5;
        this.maxEnergy = 5;
        this.strength = 10;
        this.intelligence = 5;
        this.speed = 5;
        this.weapon = new Sword();
    }
}
