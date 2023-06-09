package Monster.Troll;

import Monster.Monster;

import java.util.Random;

public class Troll extends Monster {

    public Troll() {
        super();
        this.name = "Troll";
        this.life = 20 + this.getLevel() - 1;
        this.strength = 10 + this.getLevel() - 1;
        this.speed = 0 + this.getLevel() - 1;
        this.xpGain = 30 + this.getLevel() - 1;
        this.goldGain = new Random().nextInt(20 + 1) + 10;
    }
}
