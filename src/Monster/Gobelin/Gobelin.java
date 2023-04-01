package Monster.Gobelin;

import Monster.Monster;

import java.util.Random;

public class Gobelin extends Monster {

    public Gobelin() {
        super();
        this.name = "Gobelin";
        this.life = 5 + this.getLevel() - 1;
        this.strength = 5 + this.getLevel() - 1;
        this.speed = 10 + this.getLevel() - 1;
        this.xpGain = 10 + this.getLevel() - 1;
        this.goldGain = new Random().nextInt(10 + 1);
    }
}
