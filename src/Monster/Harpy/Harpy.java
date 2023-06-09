package Monster.Harpy;

import Monster.Monster;

import java.util.Random;

public class Harpy extends Monster {

    public Harpy() {
        super();
        this.name = "Harpy";
        this.life = 15 + this.getLevel() - 1;
        this.strength = 10 + this.getLevel() - 1;
        this.speed = 10 + this.getLevel() - 1;
        this.xpGain = 20 + this.getLevel() - 1;
        this.goldGain = new Random().nextInt(10 + 1) + 5;
    }
}
